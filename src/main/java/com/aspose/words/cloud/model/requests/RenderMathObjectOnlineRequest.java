/*
 * --------------------------------------------------------------------------------
 * <copyright company="Aspose" file="RenderMathObjectOnlineRequest.java">
 *   Copyright (c) 2021 Aspose.Words for Cloud
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

package com.aspose.words.cloud.model.requests;

import com.aspose.words.cloud.*;
import com.aspose.words.cloud.model.*;
import com.aspose.words.cloud.model.responses.*;
import com.squareup.okhttp.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

/*
 * Request model for renderMathObjectOnline operation.
 */
public class RenderMathObjectOnlineRequest implements RequestIfc {
    /*
     * The document.
     */
    private byte[] document;

    /*
     * The destination format.
     */
    private String format;

    /*
     * Object index.
     */
    private Integer index;

    /*
     * The path to the node in the document tree.
     */
    private String nodePath;

    /*
     * Encoding that will be used to load an HTML (or TXT) document if the encoding is not specified in HTML.
     */
    private String loadEncoding;

    /*
     * Password for opening an encrypted document.
     */
    private String password;

    /*
     * Result path of the document after the operation. If this parameter is omitted then result of the operation will be saved as the source document.
     */
    private String destFileName;

    /*
     * Folder in filestorage with custom fonts.
     */
    private String fontsLocation;

    /*
     * Initializes a new instance of the RenderMathObjectOnlineRequest class.
     *
     * @param byte[] document The document.
     * @param String format The destination format.
     * @param Integer index Object index.
     * @param String nodePath The path to the node in the document tree.
     * @param String loadEncoding Encoding that will be used to load an HTML (or TXT) document if the encoding is not specified in HTML.
     * @param String password Password for opening an encrypted document.
     * @param String destFileName Result path of the document after the operation. If this parameter is omitted then result of the operation will be saved as the source document.
     * @param String fontsLocation Folder in filestorage with custom fonts.
     */
    public RenderMathObjectOnlineRequest(byte[] document, String format, Integer index, String nodePath, String loadEncoding, String password, String destFileName, String fontsLocation) {
        this.document = document;
        this.format = format;
        this.index = index;
        this.nodePath = nodePath;
        this.loadEncoding = loadEncoding;
        this.password = password;
        this.destFileName = destFileName;
        this.fontsLocation = fontsLocation;
    }

    /*
     * Gets The document.
     */
    public byte[] getDocument() {
        return this.document;
    }

    /*
     * Sets The document.
     */
    public void setDocument(byte[] value) {
        this.document = value;
    }

    /*
     * Gets The destination format.
     */
    public String getFormat() {
        return this.format;
    }

    /*
     * Sets The destination format.
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /*
     * Gets Object index.
     */
    public Integer getIndex() {
        return this.index;
    }

    /*
     * Sets Object index.
     */
    public void setIndex(Integer value) {
        this.index = value;
    }

    /*
     * Gets The path to the node in the document tree.
     */
    public String getNodePath() {
        return this.nodePath;
    }

    /*
     * Sets The path to the node in the document tree.
     */
    public void setNodePath(String value) {
        this.nodePath = value;
    }

    /*
     * Gets Encoding that will be used to load an HTML (or TXT) document if the encoding is not specified in HTML.
     */
    public String getLoadEncoding() {
        return this.loadEncoding;
    }

    /*
     * Sets Encoding that will be used to load an HTML (or TXT) document if the encoding is not specified in HTML.
     */
    public void setLoadEncoding(String value) {
        this.loadEncoding = value;
    }

    /*
     * Gets Password for opening an encrypted document.
     */
    public String getPassword() {
        return this.password;
    }

    /*
     * Sets Password for opening an encrypted document.
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /*
     * Gets Result path of the document after the operation. If this parameter is omitted then result of the operation will be saved as the source document.
     */
    public String getDestFileName() {
        return this.destFileName;
    }

    /*
     * Sets Result path of the document after the operation. If this parameter is omitted then result of the operation will be saved as the source document.
     */
    public void setDestFileName(String value) {
        this.destFileName = value;
    }

    /*
     * Gets Folder in filestorage with custom fonts.
     */
    public String getFontsLocation() {
        return this.fontsLocation;
    }

    /*
     * Sets Folder in filestorage with custom fonts.
     */
    public void setFontsLocation(String value) {
        this.fontsLocation = value;
    }

    /*
     * Creates the http request based on this request model.
     *
     * @param apiClient ApiClient instance
     * @throws ApiException If fail to serialize the request body object
     * @throws IOException If fail to serialize the request body object
     */
    public Request buildHttpRequest(ApiClient apiClient, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener, Boolean addAuthHeaders) throws ApiException, IOException {
        // verify the required parameter 'Document' is set
        if (getDocument() == null) {
            throw new ApiException(apiClient.getBadRequestCode(), "Missing the required parameter 'Document' when calling renderMathObjectOnline");
        }

        // verify the required parameter 'Format' is set
        if (getFormat() == null) {
            throw new ApiException(apiClient.getBadRequestCode(), "Missing the required parameter 'Format' when calling renderMathObjectOnline");
        }

        // verify the required parameter 'Index' is set
        if (getIndex() == null) {
            throw new ApiException(apiClient.getBadRequestCode(), "Missing the required parameter 'Index' when calling renderMathObjectOnline");
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/online/get/{nodePath}/OfficeMathObjects/{index}/render";
        localVarPath = apiClient.addParameterToPath(localVarPath, "index", getIndex());
        localVarPath = apiClient.addParameterToPath(localVarPath, "nodePath", getNodePath());
        localVarPath = localVarPath.replaceAll("//", "/");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        apiClient.addParameterToQuery(localVarQueryParams, "format", getFormat());
        apiClient.addParameterToQuery(localVarQueryParams, "loadEncoding", getLoadEncoding());
        apiClient.addParameterToQuery(localVarQueryParams, "password", getPassword());
        apiClient.addParameterToQuery(localVarQueryParams, "destFileName", getDestFileName());
        apiClient.addParameterToQuery(localVarQueryParams, "fontsLocation", getFontsLocation());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        if (getDocument() != null)
            localVarFormParams.put("Document", getDocument());

        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "multipart/form-data"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        return apiClient.buildRequest(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, addAuthHeaders, progressRequestListener);
    }

    /*
     * Gets response type for this request.
     */
    public Type getResponseType() {
        return RenderMathObjectOnlineResponse.class;
    }
}
