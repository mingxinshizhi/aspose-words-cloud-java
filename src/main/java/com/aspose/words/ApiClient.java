/*
 * --------------------------------------------------------------------------------
 * <copyright company="Aspose">
 *   Copyright (c) 2018 Aspose.Words for Cloud
 * </copyright>
 * <summary>
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 * </summary>
 * --------------------------------------------------------------------------------
 */
package com.aspose.words;

import com.aspose.storage.client.ApiInvoker;
import com.aspose.storage.model.ResponseMessage;
import com.aspose.words.model.AsposeResponse;
import org.apache.commons.codec.binary.Base64;
import org.threeten.bp.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.threetenbp.ThreeTenModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.client.WebResource.Builder;

import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.MediaType;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import java.net.URLEncoder;

import java.io.File;
import java.io.UnsupportedEncodingException;

import java.text.DateFormat;

import com.aspose.words.auth.Authentication;
import com.aspose.words.auth.HttpBasicAuth;
import com.aspose.words.auth.ApiKeyAuth;
import com.aspose.words.auth.OAuth;


public class ApiClient {
  private Map<String, String> defaultHeaderMap = new HashMap<String, String>();
  private String apiVersionV1 = "v1";
  private String baseUrl = "https://api.aspose.cloud/";
  private String basePath = baseUrl + apiVersionV1;
  private String clientVersion = "18.8";
  private String apiKey = "";
  private String appSid = "";
  private boolean debugging = false;
  private int connectionTimeout = 0;

  private Client httpClient;
  private ObjectMapper objectMapper;

  private Map<String, Authentication> authentications;

  private int statusCode;
  private Map<String, List<String>> responseHeaders;

  private DateFormat dateFormat;

  public ApiClient(String appKey, String appSid, String baseUrl) throws ApiException {
    if (apiKey == null || appSid == null){
        throw new IllegalArgumentException("appKey and appSid couldn't be null values");
    }
	if (baseUrl != null) {
      this.baseUrl = baseUrl;
      this.basePath = this.baseUrl + apiVersionV1;
    }

    this.apiKey = appKey;
    this.appSid = appSid;
    objectMapper = new ObjectMapper();
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    ThreeTenModule module = new ThreeTenModule();
    module.addDeserializer(Instant.class, CustomInstantDeserializer.INSTANT);
    module.addDeserializer(OffsetDateTime.class, CustomInstantDeserializer.OFFSET_DATE_TIME);
    module.addDeserializer(ZonedDateTime.class, CustomInstantDeserializer.ZONED_DATE_TIME);
    objectMapper.registerModule(module);
    objectMapper.setDateFormat(ApiClient.buildDefaultDateFormat());

    dateFormat = ApiClient.buildDefaultDateFormat();

    // Set default User-Agent.
    setUserAgent("Swagger-Codegen/18.8/java");
	addDefaultHeader("x-aspose-client", "java sdk");
	addDefaultHeader("x-aspose-client-version", clientVersion);

    // Setup authentications (key: authentication name, value: authentication).
    authentications = new HashMap<String, Authentication>();
    authentications.put("appsid", new ApiKeyAuth("query", "Appsid"));
    authentications.put("oauth", new OAuth());
    authentications.put("signature", new ApiKeyAuth("query", "Signature"));
    // Prevent the authentications from being modified.
    authentications = Collections.unmodifiableMap(authentications);

    rebuildHttpClient();
    getRequestToken();
  }

  public static DateFormat buildDefaultDateFormat() {
    return new RFC3339DateFormat();
  }

  /**
   * Build the Client used to make HTTP requests with the latest settings,
   * i.e. objectMapper and debugging.
   * TODO: better to use the Builder Pattern?
   * @return API client
   */
  public ApiClient rebuildHttpClient() {
    // Add the JSON serialization support to Jersey
    JacksonJsonProvider jsonProvider = new JacksonJsonProvider(objectMapper);
    DefaultClientConfig conf = new DefaultClientConfig();
    conf.getSingletons().add(jsonProvider);
    Client client = Client.create(conf);
    client.addFilter(new GZIPContentEncodingFilter(false));
    if (debugging) {
      client.addFilter(new LoggingFilter());
    }
    this.httpClient = client;
    return this;
  }

  /**
   * Returns the current object mapper used for JSON serialization/deserialization.
   * <p>
   * Note: If you make changes to the object mapper, remember to set it back via
   * <code>setObjectMapper</code> in order to trigger HTTP client rebuilding.
   * </p>
   * @return Object mapper
   */
  public ObjectMapper getObjectMapper() {
    return objectMapper;
  }

  public ApiClient setObjectMapper(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
    // Need to rebuild the Client as it depends on object mapper.
    rebuildHttpClient();
    return this;
  }

  public String getAppSid(){
      return this.appSid;
  }

  public Client getHttpClient() {
    return httpClient;
  }

  public ApiClient setHttpClient(Client httpClient) {
    this.httpClient = httpClient;
    return this;
  }

  public String getBasePath() {
    return basePath;
  }

  public ApiClient setBasePath(String basePath) {
    this.basePath = basePath;
    return this;
  }

  /**
   * Gets the status code of the previous request
   * @return Status code
   */
  public int getStatusCode() {
    return statusCode;
  }

  /**
   * Gets the response headers of the previous request
   * @return Response headers
   */
  public Map<String, List<String>> getResponseHeaders() {
    return responseHeaders;
  }

  /**
   * Get authentications (key: authentication name, value: authentication).
   * @return Map of authentication
   */
  public Map<String, Authentication> getAuthentications() {
    return authentications;
  }

  /**
   * Get authentication for the given name.
   *
   * @param authName The authentication name
   * @return The authentication, null if not found
   */
  public Authentication getAuthentication(String authName) {
    return authentications.get(authName);
  }

  /**
   * Helper method to set username for the first HTTP basic authentication.
   * @param username Username
   */
  public void setUsername(String username) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof HttpBasicAuth) {
        ((HttpBasicAuth) auth).setUsername(username);
        return;
      }
    }
    throw new RuntimeException("No HTTP basic authentication configured!");
  }

  /**
   * Helper method to set password for the first HTTP basic authentication.
   * @param password Password
   */
  public void setPassword(String password) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof HttpBasicAuth) {
        ((HttpBasicAuth) auth).setPassword(password);
        return;
      }
    }
    throw new RuntimeException("No HTTP basic authentication configured!");
  }

  /**
   * Helper method to set API key value for the first API key authentication.
   * @param apiKey API key
   */
  public void setApiKey(String apiKey) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof ApiKeyAuth) {
        ((ApiKeyAuth) auth).setApiKey(apiKey);
        return;
      }
    }
    throw new RuntimeException("No API key authentication configured!");
  }

  /**
   * Helper method to set API key prefix for the first API key authentication.
   * @param apiKeyPrefix API key prefix
   */
  public void setApiKeyPrefix(String apiKeyPrefix) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof ApiKeyAuth) {
        ((ApiKeyAuth) auth).setApiKeyPrefix(apiKeyPrefix);
        return;
      }
    }
    throw new RuntimeException("No API key authentication configured!");
  }

  /**
   * Helper method to set access token for the first OAuth2 authentication.
   * @param accessToken Access token
   */
  public void setAccessToken(String accessToken) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof OAuth) {
        ((OAuth) auth).setAccessToken(accessToken);
        return;
      }
    }
    throw new RuntimeException("No OAuth2 authentication configured!");
  }

  /**
   * Set the User-Agent header's value (by adding to the default header map).
   * @param userAgent User agent
   * @return API client
   */
  public ApiClient setUserAgent(String userAgent) {
    addDefaultHeader("User-Agent", userAgent);
    return this;
  }

  /**
   * Add a default header.
   *
   * @param key The header's key
   * @param value The header's value
   * @return API client
   */
  public ApiClient addDefaultHeader(String key, String value) {
    defaultHeaderMap.put(key, value);
    return this;
  }

  /**
   * Check that whether debugging is enabled for this API client.
   * @return True if debugging is on
   */
  public boolean isDebugging() {
    return debugging;
  }

  /**
   * Enable/disable debugging for this API client.
   *
   * @param debugging To enable (true) or disable (false) debugging
   * @return API client
   */
  public ApiClient setDebugging(boolean debugging) {
    this.debugging = debugging;
    // Need to rebuild the Client as it depends on the value of debugging.
    rebuildHttpClient();
    return this;
  }

  /**
   * Connect timeout (in milliseconds).
   * @return Connection timeout
   */
  public int getConnectTimeout() {
    return connectionTimeout;
  }

  /**
   * Set the connect timeout (in milliseconds).
   * A value of 0 means no timeout, otherwise values must be between 1 and
   * {@link Integer#MAX_VALUE}.
   * @param connectionTimeout Connection timeout in milliseconds
   * @return API client
   */
   public ApiClient setConnectTimeout(int connectionTimeout) {
     this.connectionTimeout = connectionTimeout;
     httpClient.setConnectTimeout(connectionTimeout);
     return this;
   }

  /**
   * Get the date format used to parse/format date parameters.
   * @return Date format
   */
  public DateFormat getDateFormat() {
    return dateFormat;
  }

  /**
   * Set the date format used to parse/format date parameters.
   * @param dateFormat Date format
   * @return API client
   */
  public ApiClient setDateFormat(DateFormat dateFormat) {
    this.dateFormat = dateFormat;
    // Also set the date format for model (de)serialization with Date properties.
    this.objectMapper.setDateFormat((DateFormat) dateFormat.clone());
    // Need to rebuild the Client as objectMapper changes.
    rebuildHttpClient();
    return this;
  }

  /**
   * Parse the given string into Date object.
   * @param str String
   * @return Date
   */
  public Date parseDate(String str) {
    try {
      return dateFormat.parse(str);
    } catch (java.text.ParseException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Format the given Date object into string.
   * @param date Date
   * @return Date in string format
   */
  public String formatDate(Date date) {
    return dateFormat.format(date);
  }

  /**
   * Format the given parameter object into string.
   * @param param Object
   * @return Object in string format
   */
  public String parameterToString(Object param) {
    if (param == null) {
      return "";
    } else if (param instanceof Date) {
      return formatDate((Date) param);
    } else if (param instanceof Collection) {
      StringBuilder b = new StringBuilder();
      for(Object o : (Collection<?>)param) {
        if(b.length() > 0) {
          b.append(',');
        }
        b.append(String.valueOf(o));
      }
      return b.toString();
    } else {
      return String.valueOf(param);
    }
  }

  /**
   * Formats the specified query parameter to a list containing a single {@code Pair} object.
   *
   * Note that {@code value} must not be a collection.
   *
   * @param name The name of the parameter.
   * @param value The value of the parameter.
   * @return A list containing a single {@code Pair} object.
   */
  public List<Pair> parameterToPair(String name, Object value) {
    List<Pair> params = new ArrayList<Pair>();

    // preconditions
    if (name == null || name.isEmpty() || value == null || value instanceof Collection) return params;

    params.add(new Pair(name, parameterToString(value)));
    return params;
  }

  /**
   * Formats the specified collection query parameters to a list of {@code Pair} objects.
   *
   * Note that the values of each of the returned Pair objects are percent-encoded.
   *
   * @param collectionFormat The collection format of the parameter.
   * @param name The name of the parameter.
   * @param value The value of the parameter.
   * @return A list of {@code Pair} objects.
   */
  public List<Pair> parameterToPairs(String collectionFormat, String name, Collection value) {
    List<Pair> params = new ArrayList<Pair>();

    // preconditions
    if (name == null || name.isEmpty() || value == null) {
      return params;
    }

    // create the params based on the collection format
    if ("multi".equals(collectionFormat)) {
      for (Object item : value) {
        params.add(new Pair(name, escapeString(parameterToString(item))));
      }
      return params;
    }

    // collectionFormat is assumed to be "csv" by default
    String delimiter = ",";

    // escape all delimiters except commas, which are URI reserved
    // characters
    if ("ssv".equals(collectionFormat)) {
      delimiter = escapeString(" ");
    } else if ("tsv".equals(collectionFormat)) {
      delimiter = escapeString("\t");
    } else if ("pipes".equals(collectionFormat)) {
      delimiter = escapeString("|");
    }

    StringBuilder sb = new StringBuilder() ;
    for (Object item : value) {
      sb.append(delimiter);
      sb.append(escapeString(parameterToString(item)));
    }

    params.add(new Pair(name, sb.substring(delimiter.length())));

    return params;
  }

  /**
   * Check if the given MIME is a JSON MIME.
   * JSON MIME examples:
   *   application/json
   *   application/json; charset=UTF8
   *   APPLICATION/JSON
   *   application/vnd.company+json
   * @param mime MIME
   * @return True if MIME type is boolean
   */
  public boolean isJsonMime(String mime) {
    String jsonMime = "(?i)^(application/json|[^;/ \t]+/[^;/ \t]+[+]json)[ \t]*(;.*)?$";
    return mime != null && (mime.matches(jsonMime) || mime.equals("*/*"));
  }

  /**
   * Select the Accept header's value from the given accepts array:
   *   if JSON exists in the given array, use it;
   *   otherwise use all of them (joining into a string)
   *
   * @param accepts The accepts array to select from
   * @return The Accept header to use. If the given array is empty,
   *   null will be returned (not to set the Accept header explicitly).
   */
  public String selectHeaderAccept(String[] accepts) {
    if (accepts.length == 0) {
      return null;
    }
    for (String accept : accepts) {
      if (isJsonMime(accept)) {
        return accept;
      }
    }
    return StringUtil.join(accepts, ",");
  }

  /**
   * Select the Content-Type header's value from the given array:
   *   if JSON exists in the given array, use it;
   *   otherwise use the first one of the array.
   *
   * @param contentTypes The Content-Type array to select from
   * @return The Content-Type header to use. If the given array is empty,
   *   or matches "any", JSON will be used.
   */
  public String selectHeaderContentType(String[] contentTypes) {
    if (contentTypes.length == 0 || contentTypes[0].equals("*/*")) {
      return "application/json";
    }
    for (String contentType : contentTypes) {
      if (isJsonMime(contentType)) {
        return contentType;
      }
    }
    return contentTypes[0];
  }

  /**
   * Escape the given string to be used as URL query value.
   * @param str String
   * @return Escaped string
   */
  public String escapeString(String str) {
    try {
      return URLEncoder.encode(str, "utf8").replaceAll("\\+", "%20");
    } catch (UnsupportedEncodingException e) {
      return str;
    }
  }

  /**
   * Serialize the given Java object into string according the given
   * Content-Type (only JSON is supported for now).
   * @param obj Object
   * @param contentType Content type
   * @param formParams Form parameters
   * @return Object
   * @throws ApiException API exception
   */
  public Object serialize(Object obj, String contentType, Map<String, Object> formParams) throws ApiException {
    if (contentType.startsWith("multipart/form-data")) {
      FormDataMultiPart mp = new FormDataMultiPart();
      for (Entry<String, Object> param: formParams.entrySet()) {
        if( param.getValue() instanceof List && !( ( List ) param.getValue() ).isEmpty()
                  && ( ( List ) param.getValue() ).get( 0 ) instanceof File ) {
            @SuppressWarnings( "unchecked" )
            List<File> files = ( List<File> ) param.getValue();
            for( File file : files ) {
              mp.bodyPart( new FileDataBodyPart( param.getKey(), file, MediaType.APPLICATION_OCTET_STREAM_TYPE ) );
            }
        } else if (param.getValue() instanceof File) {
          File file = (File) param.getValue();
          mp.bodyPart(new FileDataBodyPart(param.getKey(), file, MediaType.APPLICATION_OCTET_STREAM_TYPE));
        } else {
          mp.field(param.getKey(), parameterToString(param.getValue()), MediaType.MULTIPART_FORM_DATA_TYPE);
        }
      }
      return mp;
    } else if (contentType.startsWith("application/x-www-form-urlencoded")) {
      return this.getXWWWFormUrlencodedParams(formParams);
    } else {
      // We let Jersey attempt to serialize the body
      return obj;
    }
  }

  /**
   * Build full URL by concatenating base path, the given sub path and query parameters.
   *
   * @param path The sub path
   * @param queryParams The query parameters
   * @param collectionQueryParams The collection query parameters
   * @return The full URL
   */
  private String buildUrl(String path, List<Pair> queryParams, List<Pair> collectionQueryParams, String authNames) {
    final StringBuilder url = new StringBuilder();
    url.append(path == "/oauth2/token" ? this.baseUrl : this.basePath).append(path);

    if (queryParams != null && !queryParams.isEmpty()) {
      // support (constant) query string in `path`, e.g. "/posts?draft=1"
      String prefix = path.contains("?") ? "&" : "?";
      for (Pair param : queryParams) {
        if (param.getValue() != null) {
          if (prefix != null) {
            url.append(prefix);
            prefix = null;
          } else {
            url.append("&");
          }
          String value = parameterToString(param.getValue());
          url.append(escapeString(param.getName())).append("=").append(escapeString(value));
        }
      }
    }

    if (collectionQueryParams != null && !collectionQueryParams.isEmpty()) {
      String prefix = url.toString().contains("?") ? "&" : "?";
      for (Pair param : collectionQueryParams) {
        if (param.getValue() != null) {
          if (prefix != null) {
            url.append(prefix);
            prefix = null;
          } else {
            url.append("&");
          }
          String value = parameterToString(param.getValue());
          // collection query parameter value already escaped as part of parameterToPairs
          url.append(escapeString(param.getName())).append("=").append(value);
        }
      }
    }

    if (authNames != null && authNames.equals("signature")){
         String signature = "";
        signature = Sign(url.toString(), apiKey);
        return url.append("&signature=").append(signature).toString();
    }

    return url.toString();
  }

  private ClientResponse getAPIResponse(String path, String method, List<Pair> queryParams, List<Pair> collectionQueryParams, Object body, Map<String, String> headerParams, Map<String, Object> formParams, String accept, String contentType, String[] authNames) throws ApiException {
    if (body != null && !formParams.isEmpty()) {
      throw new ApiException(500, "Cannot have body and form params");
    }

    updateParamsForAuth(authNames, queryParams, headerParams);

    final String url = buildUrl(path, queryParams, collectionQueryParams, authNames.length > 0 ? authNames[0] : null);
    Builder builder;
    if (accept == null) {
      builder = httpClient.resource(url).getRequestBuilder();
    } else {
      builder = httpClient.resource(url).accept(accept);
    }

    for (Entry<String, String> keyValue : headerParams.entrySet()) {
      builder = builder.header(keyValue.getKey(), keyValue.getValue());
    }
    for (Map.Entry<String,String> keyValue : defaultHeaderMap.entrySet()) {
      if (!headerParams.containsKey(keyValue.getKey())) {
        builder = builder.header(keyValue.getKey(), keyValue.getValue());
      }
    }

    ClientResponse response = null;

    if ("GET".equals(method)) {
      response = (ClientResponse) builder.get(ClientResponse.class);
    } else if ("POST".equals(method)) {
      response = builder.type(contentType).post(ClientResponse.class, serialize(body, contentType, formParams));
    } else if ("PUT".equals(method)) {
      response = builder.type(contentType).put(ClientResponse.class, serialize(body, contentType, formParams));
    } else if ("DELETE".equals(method)) {
      response = builder.type(contentType).delete(ClientResponse.class, serialize(body, contentType, formParams));
    } else if ("PATCH".equals(method)) {
      response = builder.type(contentType).header("X-HTTP-Method-Override", "PATCH").post(ClientResponse.class, serialize(body, contentType, formParams));
    } else if ("HEAD".equals(method)) {
      response = builder.head();
    } else {
      throw new ApiException(500, "unknown method type " + method);
    }
    return response;
  }

  /**
   * Invoke API by sending HTTP request with the given options.
   *
   * @param <T> Type
   * @param path The sub-path of the HTTP URL
   * @param method The request method, one of "GET", "POST", "PUT", and "DELETE"
   * @param queryParams The query parameters
   * @param collectionQueryParams The collection query parameters
   * @param body The request body object - if it is not binary, otherwise null
   * @param headerParams The header parameters
   * @param formParams The form parameters
   * @param accept The request's Accept header
   * @param contentType The request's Content-Type header
   * @param authNames The authentications to apply
   * @param returnType Return type
   * @return The response body in type of string
   * @throws ApiException API exception
   */
   public <T> T invokeAPI(String path, String method, List<Pair> queryParams, List<Pair> collectionQueryParams, Object body, Map<String, String> headerParams, Map<String, Object> formParams, String accept, String contentType, String[] authNames, GenericType<T> returnType) throws ApiException {

    ClientResponse response = getAPIResponse(path, method, queryParams, collectionQueryParams, body, headerParams, formParams, accept, contentType, authNames);

    statusCode = response.getStatusInfo().getStatusCode();
    responseHeaders = response.getHeaders();

    if(response.getStatusInfo().getStatusCode() == ClientResponse.Status.NO_CONTENT.getStatusCode()) {
      return null;
    } else if (response.getStatusInfo().getFamily() == Family.SUCCESSFUL) {
      if (returnType == null)
        return null;
      else
        return response.getEntity(returnType);
    } else {
      String message = "error";
      String respBody = null;
      if (response.hasEntity()) {
        try {
          respBody = response.getEntity(String.class);
          message = respBody;
        } catch (RuntimeException e) {
          // e.printStackTrace();
        }
      }
      throw new ApiException(
        response.getStatusInfo().getStatusCode(),
        message,
        response.getHeaders(),
        respBody);
    }
  }

    private static String Sign(String unsignedURL, String privateKey) {

        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(privateKey.getBytes(), "HmacSHA1"));

            String signature = new String(Base64.encodeBase64(mac.doFinal(unsignedURL.getBytes())));

            if (signature.endsWith("=")) {
                signature = signature.substring(0, signature.length() - 1);
            }

            return URLEncoder.encode(signature, "UTF-8");

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }

        return null;
    }


  /**
   * Update query and header parameters based on authentication settings.
   *
   * @param authNames The authentications to apply
   * @param queryParams Query parameters
   * @param headerParams Header parameters
   */
  private void updateParamsForAuth(String[] authNames, List<Pair> queryParams, Map<String, String> headerParams) {
    for (String authName : authNames) {
      Authentication auth = authentications.get(authName);
      if (auth == null) throw new RuntimeException("Authentication undefined: " + authName);
      auth.applyToParams(queryParams, headerParams);
    }
  }

  /**
   * Encode the given form parameters as request body.
   * @param formParams Form parameters
   * @return HTTP form encoded parameters
   */
  private String getXWWWFormUrlencodedParams(Map<String, Object> formParams) {
    StringBuilder formParamBuilder = new StringBuilder();

    for (Entry<String, Object> param : formParams.entrySet()) {
      String valueStr = parameterToString(param.getValue());
      try {
        formParamBuilder.append(URLEncoder.encode(param.getKey(), "utf8"))
            .append("=")
            .append(URLEncoder.encode(valueStr, "utf8"));
        formParamBuilder.append("&");
      } catch (UnsupportedEncodingException e) {
        // move on to next
      }
    }

    String encodedFormParams = formParamBuilder.toString();
    if (encodedFormParams.endsWith("&")) {
      encodedFormParams = encodedFormParams.substring(0, encodedFormParams.length() - 1);
    }

    return encodedFormParams;
  }
  
  private void getRequestToken() throws ApiException {
	final String path = "/oauth2/token";
	final String body = String.format("grant_type=client_credentials&client_id=%s&client_secret=%s", appSid, apiKey);
	HashMap<String, String> response = invokeAPI(path, "POST", new ArrayList<Pair>(), new ArrayList<Pair>(), body,
            new HashMap<String, String>(), new HashMap<String, Object>(), "application/json", "plain/text", new String[]{}, new GenericType<HashMap<String, String>>(){});
	this.setAccessToken(response.get("access_token"));
  }
}
