/*
 * --------------------------------------------------------------------------------
 * <copyright company="Aspose" file="GetBookmarkByNameRequest.java">
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
 * Request model for getBookmarkByName operation.
 */
public class GetBookmarkByNameRequest implements RequestIfc {
    /*
     * The filename of the input document.
     */
    private String name;

    /*
     * The name of the bookmark.
     */
    private String bookmarkName;

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
     * Initializes a new instance of the GetBookmarkByNameRequest class.
     *
     * @param String name The filename of the input document.
     * @param String bookmarkName The name of the bookmark.
     * @param String folder Original document folder.
     * @param String storage Original document storage.
     * @param String loadEncoding Encoding that will be used to load an HTML (or TXT) document if the encoding is not specified in HTML.
     * @param String password Password for opening an encrypted document.
     */
    public GetBookmarkByNameRequest(String name, String bookmarkName, String folder, String storage, String loadEncoding, String password) {
        this.name = name;
        this.bookmarkName = bookmarkName;
        this.folder = folder;
        this.storage = storage;
        this.loadEncoding = loadEncoding;
        this.password = password;
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
     * Gets The name of the bookmark.
     */
    public String getBookmarkName() {
        return this.bookmarkName;
    }

    /*
     * Sets The name of the bookmark.
     */
    public void setBookmarkName(String value) {
        this.bookmarkName = value;
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
     * Creates the http request based on this request model.
     *
     * @param apiClient ApiClient instance
     * @throws ApiException If fail to serialize the request body object
     * @throws IOException If fail to serialize the request body object
     */
    public Request buildHttpRequest(ApiClient apiClient, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener, Boolean addAuthHeaders) throws ApiException, IOException {
        // verify the required parameter 'Name' is set
        if (getName() == null) {
            throw new ApiException(apiClient.getBadRequestCode(), "Missing the required parameter 'Name' when calling getBookmarkByName");
        }

        // verify the required parameter 'BookmarkName' is set
        if (getBookmarkName() == null) {
            throw new ApiException(apiClient.getBadRequestCode(), "Missing the required parameter 'BookmarkName' when calling getBookmarkByName");
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/bookmarks/{bookmarkName}";
        localVarPath = apiClient.addParameterToPath(localVarPath, "name", getName());
        localVarPath = apiClient.addParameterToPath(localVarPath, "bookmarkName", getBookmarkName());
        localVarPath = localVarPath.replaceAll("//", "/");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        apiClient.addParameterToQuery(localVarQueryParams, "folder", getFolder());
        apiClient.addParameterToQuery(localVarQueryParams, "storage", getStorage());
        apiClient.addParameterToQuery(localVarQueryParams, "loadEncoding", getLoadEncoding());
        apiClient.addParameterToQuery(localVarQueryParams, "password", getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();

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

        return apiClient.buildRequest(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, addAuthHeaders, progressRequestListener);
    }

    /*
     * Gets response type for this request.
     */
    public Type getResponseType() {
        return BookmarkResponse.class;
    }
}
