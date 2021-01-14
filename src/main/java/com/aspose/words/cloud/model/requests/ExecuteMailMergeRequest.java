/*
 * --------------------------------------------------------------------------------
 * <copyright company="Aspose" file="ExecuteMailMergeRequest.java">
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
import javax.mail.MessagingException;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

/*
 * Request model for executeMailMerge operation.
 */
public class ExecuteMailMergeRequest implements RequestIfc {
    /*
     * The filename of the input document.
     */
    private String name;

    /*
     * Mail merge data.
     */
    private String data;

    /*
     * Original document folder.
     */
    private String folder;

    /*
     * Original document storage.
     */
    private String storage;

    /*
     * Encoding that will be used to load an HTML (or TXT) document if the encoding is not specified in HTML.
     */
    private String loadEncoding;

    /*
     * Password for opening an encrypted document.
     */
    private String password;

    /*
     * The flag indicating whether to execute Mail Merge operation with regions.
     */
    private Boolean withRegions;

    /*
     * The data file.
     */
    private String mailMergeDataFile;

    /*
     * The cleanup options.
     */
    private String cleanup;

    /*
     * The flag indicating whether paragraph with TableStart or TableEnd field should be fully included into mail merge region or particular range between TableStart and TableEnd fields. The default value is true.
     */
    private Boolean useWholeParagraphAsRegion;

    /*
     * The filename of the output document. If this parameter is omitted, the result will be saved with autogenerated name.
     */
    private String destFileName;

    /*
     * Initializes a new instance of the ExecuteMailMergeRequest class.
     *
     * @param String name The filename of the input document.
     * @param String data Mail merge data.
     * @param String folder Original document folder.
     * @param String storage Original document storage.
     * @param String loadEncoding Encoding that will be used to load an HTML (or TXT) document if the encoding is not specified in HTML.
     * @param String password Password for opening an encrypted document.
     * @param Boolean withRegions The flag indicating whether to execute Mail Merge operation with regions.
     * @param String mailMergeDataFile The data file.
     * @param String cleanup The cleanup options.
     * @param Boolean useWholeParagraphAsRegion The flag indicating whether paragraph with TableStart or TableEnd field should be fully included into mail merge region or particular range between TableStart and TableEnd fields. The default value is true.
     * @param String destFileName The filename of the output document. If this parameter is omitted, the result will be saved with autogenerated name.
     */
    public ExecuteMailMergeRequest(String name, String data, String folder, String storage, String loadEncoding, String password, Boolean withRegions, String mailMergeDataFile, String cleanup, Boolean useWholeParagraphAsRegion, String destFileName) {
        this.name = name;
        this.data = data;
        this.folder = folder;
        this.storage = storage;
        this.loadEncoding = loadEncoding;
        this.password = password;
        this.withRegions = withRegions;
        this.mailMergeDataFile = mailMergeDataFile;
        this.cleanup = cleanup;
        this.useWholeParagraphAsRegion = useWholeParagraphAsRegion;
        this.destFileName = destFileName;
    }

    /*
     * Gets The filename of the input document.
     */
    public String getName() {
        return this.name;
    }

    /*
     * Sets The filename of the input document.
     */
    public void setName(String value) {
        this.name = value;
    }

    /*
     * Gets Mail merge data.
     */
    public String getData() {
        return this.data;
    }

    /*
     * Sets Mail merge data.
     */
    public void setData(String value) {
        this.data = value;
    }

    /*
     * Gets Original document folder.
     */
    public String getFolder() {
        return this.folder;
    }

    /*
     * Sets Original document folder.
     */
    public void setFolder(String value) {
        this.folder = value;
    }

    /*
     * Gets Original document storage.
     */
    public String getStorage() {
        return this.storage;
    }

    /*
     * Sets Original document storage.
     */
    public void setStorage(String value) {
        this.storage = value;
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
     * Gets The flag indicating whether to execute Mail Merge operation with regions.
     */
    public Boolean getWithRegions() {
        return this.withRegions;
    }

    /*
     * Sets The flag indicating whether to execute Mail Merge operation with regions.
     */
    public void setWithRegions(Boolean value) {
        this.withRegions = value;
    }

    /*
     * Gets The data file.
     */
    public String getMailMergeDataFile() {
        return this.mailMergeDataFile;
    }

    /*
     * Sets The data file.
     */
    public void setMailMergeDataFile(String value) {
        this.mailMergeDataFile = value;
    }

    /*
     * Gets The cleanup options.
     */
    public String getCleanup() {
        return this.cleanup;
    }

    /*
     * Sets The cleanup options.
     */
    public void setCleanup(String value) {
        this.cleanup = value;
    }

    /*
     * Gets The flag indicating whether paragraph with TableStart or TableEnd field should be fully included into mail merge region or particular range between TableStart and TableEnd fields. The default value is true.
     */
    public Boolean getUseWholeParagraphAsRegion() {
        return this.useWholeParagraphAsRegion;
    }

    /*
     * Sets The flag indicating whether paragraph with TableStart or TableEnd field should be fully included into mail merge region or particular range between TableStart and TableEnd fields. The default value is true.
     */
    public void setUseWholeParagraphAsRegion(Boolean value) {
        this.useWholeParagraphAsRegion = value;
    }

    /*
     * Gets The filename of the output document. If this parameter is omitted, the result will be saved with autogenerated name.
     */
    public String getDestFileName() {
        return this.destFileName;
    }

    /*
     * Sets The filename of the output document. If this parameter is omitted, the result will be saved with autogenerated name.
     */
    public void setDestFileName(String value) {
        this.destFileName = value;
    }


    /*
     * Creates the http request based on this request model.
     *
     * @param apiClient ApiClient instance
     * @throws ApiException If fail to serialize the request body object
     * @throws IOException If fail to serialize the request body object
     */
    public Request buildHttpRequest(ApiClient apiClient, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener, Boolean addAuthHeaders) throws ApiException, IOException {
        // verify the required parameter 'Name' is set
        if (getName() == null) {
            throw new ApiException(apiClient.getBadRequestCode(), "Missing the required parameter 'Name' when calling executeMailMerge");
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/MailMerge";
        localVarPath = apiClient.addParameterToPath(localVarPath, "name", getName());
        localVarPath = localVarPath.replaceAll("//", "/");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        apiClient.addParameterToQuery(localVarQueryParams, "folder", getFolder());
        apiClient.addParameterToQuery(localVarQueryParams, "storage", getStorage());
        apiClient.addParameterToQuery(localVarQueryParams, "loadEncoding", getLoadEncoding());
        apiClient.addParameterToQuery(localVarQueryParams, "password", getPassword());
        apiClient.addParameterToQuery(localVarQueryParams, "withRegions", getWithRegions());
        apiClient.addParameterToQuery(localVarQueryParams, "mailMergeDataFile", getMailMergeDataFile());
        apiClient.addParameterToQuery(localVarQueryParams, "cleanup", getCleanup());
        apiClient.addParameterToQuery(localVarQueryParams, "useWholeParagraphAsRegion", getUseWholeParagraphAsRegion());
        apiClient.addParameterToQuery(localVarQueryParams, "destFileName", getDestFileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        if (getData() != null)
            localVarFormParams.put("Data", getData());

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
        return DocumentResponse.class;
    }

    /*
     * Deserialize response message.
     *
     * @param apiClient ApiClient instance
     * @param response Response instance
     */
    public DocumentResponse deserializeResponse(ApiClient apiClient, Response response) throws ApiException, MessagingException, IOException {
        return (DocumentResponse) apiClient.deserialize(response, DocumentResponse.class);
    }
}
