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

package com.aspose.words.cloud.api;

import com.aspose.words.cloud.*;
import com.aspose.words.cloud.model.*;
import com.aspose.words.cloud.model.requests.*;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.File;
import java.lang.reflect.Type;
import java.util.*;


public class WordsApi {
    private Integer NotAuth = 401;
    private Integer BadRequest = 400;
    private ApiClient apiClient;

    public WordsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public WordsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for acceptAllRevisions
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call acceptAllRevisionsCall(AcceptAllRevisionsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/revisions/acceptAll"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call acceptAllRevisionsValidateBeforeCall(AcceptAllRevisionsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling acceptAllRevisions");
        }
        

        com.squareup.okhttp.Call call = acceptAllRevisionsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Accepts all revisions in document
     * 
     * @return RevisionsModificationResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public RevisionsModificationResponse acceptAllRevisions(AcceptAllRevisionsRequest request) throws ApiException {
        try {
            ApiResponse<RevisionsModificationResponse> resp = acceptAllRevisionsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<RevisionsModificationResponse> resp = acceptAllRevisionsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Accepts all revisions in document
     * 
     * @return ApiResponse&lt;RevisionsModificationResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<RevisionsModificationResponse> acceptAllRevisionsWithHttpInfo(AcceptAllRevisionsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = acceptAllRevisionsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<RevisionsModificationResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Accepts all revisions in document (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call acceptAllRevisionsAsync(AcceptAllRevisionsRequest request, final ApiCallback<RevisionsModificationResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = acceptAllRevisionsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<RevisionsModificationResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for appendDocument
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call appendDocumentCall(AppendDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getDocumentList();

        // create path and map variables
        String localVarPath = "/words/{name}/appendDocument"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call appendDocumentValidateBeforeCall(AppendDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling appendDocument");
        }
        
        // verify the required parameter 'DocumentList' is set
        if (request.getDocumentList() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'DocumentList' when calling appendDocument");
        }
        

        com.squareup.okhttp.Call call = appendDocumentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Appends documents to original document.
     * 
     * @return DocumentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentResponse appendDocument(AppendDocumentRequest request) throws ApiException {
        try {
            ApiResponse<DocumentResponse> resp = appendDocumentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentResponse> resp = appendDocumentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Appends documents to original document.
     * 
     * @return ApiResponse&lt;DocumentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentResponse> appendDocumentWithHttpInfo(AppendDocumentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = appendDocumentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Appends documents to original document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call appendDocumentAsync(AppendDocumentRequest request, final ApiCallback<DocumentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = appendDocumentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for classify
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call classifyCall(ClassifyRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getText();

        // create path and map variables
        String localVarPath = "/words/classify";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "bestClassesCount", request.getBestClassesCount());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call classifyValidateBeforeCall(ClassifyRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Text' is set
        if (request.getText() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Text' when calling classify");
        }
        

        com.squareup.okhttp.Call call = classifyCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Classifies raw text.
     * 
     * @return ClassificationResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ClassificationResponse classify(ClassifyRequest request) throws ApiException {
        try {
            ApiResponse<ClassificationResponse> resp = classifyWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ClassificationResponse> resp = classifyWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Classifies raw text.
     * 
     * @return ApiResponse&lt;ClassificationResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ClassificationResponse> classifyWithHttpInfo(ClassifyRequest request) throws ApiException {
        com.squareup.okhttp.Call call = classifyValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ClassificationResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Classifies raw text. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call classifyAsync(ClassifyRequest request, final ApiCallback<ClassificationResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = classifyValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ClassificationResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for classifyDocument
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call classifyDocumentCall(ClassifyDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{documentName}/classify"
            .replaceAll("\\{" + "documentName" + "\\}", apiClient.escapeString(request.getDocumentName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "bestClassesCount", request.getBestClassesCount());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "taxonomy", request.getTaxonomy());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call classifyDocumentValidateBeforeCall(ClassifyDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'DocumentName' is set
        if (request.getDocumentName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'DocumentName' when calling classifyDocument");
        }
        

        com.squareup.okhttp.Call call = classifyDocumentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Classifies document.
     * 
     * @return ClassificationResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ClassificationResponse classifyDocument(ClassifyDocumentRequest request) throws ApiException {
        try {
            ApiResponse<ClassificationResponse> resp = classifyDocumentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ClassificationResponse> resp = classifyDocumentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Classifies document.
     * 
     * @return ApiResponse&lt;ClassificationResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ClassificationResponse> classifyDocumentWithHttpInfo(ClassifyDocumentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = classifyDocumentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ClassificationResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Classifies document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call classifyDocumentAsync(ClassifyDocumentRequest request, final ApiCallback<ClassificationResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = classifyDocumentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ClassificationResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for compareDocument
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call compareDocumentCall(CompareDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getCompareData();

        // create path and map variables
        String localVarPath = "/words/{name}/compareDocument"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call compareDocumentValidateBeforeCall(CompareDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling compareDocument");
        }
        
        // verify the required parameter 'CompareData' is set
        if (request.getCompareData() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'CompareData' when calling compareDocument");
        }
        

        com.squareup.okhttp.Call call = compareDocumentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Compares document with original document.
     * 
     * @return DocumentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentResponse compareDocument(CompareDocumentRequest request) throws ApiException {
        try {
            ApiResponse<DocumentResponse> resp = compareDocumentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentResponse> resp = compareDocumentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Compares document with original document.
     * 
     * @return ApiResponse&lt;DocumentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentResponse> compareDocumentWithHttpInfo(CompareDocumentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = compareDocumentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Compares document with original document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call compareDocumentAsync(CompareDocumentRequest request, final ApiCallback<DocumentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = compareDocumentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for convertDocument
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call convertDocumentCall(ConvertDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/convert";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "format", request.getFormat());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "outPath", request.getOutPath());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileNameFieldValue", request.getFileNameFieldValue());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fontsLocation", request.getFontsLocation());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        if (request.getDocument() != null)
          localVarFormParams.put("Document", request.getDocument());

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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call convertDocumentValidateBeforeCall(ConvertDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Document' is set
        if (request.getDocument() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Document' when calling convertDocument");
        }
        
        // verify the required parameter 'Format' is set
        if (request.getFormat() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Format' when calling convertDocument");
        }
        

        com.squareup.okhttp.Call call = convertDocumentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Converts document from the request&#39;s content to the specified format .
     * 
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File convertDocument(ConvertDocumentRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = convertDocumentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = convertDocumentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Converts document from the request&#39;s content to the specified format .
     * 
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> convertDocumentWithHttpInfo(ConvertDocumentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = convertDocumentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Converts document from the request&#39;s content to the specified format . (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call convertDocumentAsync(ConvertDocumentRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = convertDocumentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for copyFile
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call copyFileCall(CopyFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/storage/file/copy/{srcPath}"
            .replaceAll("\\{" + "srcPath" + "\\}", apiClient.escapeString(request.getSrcPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destPath", request.getDestPath());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "srcStorageName", request.getSrcStorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destStorageName", request.getDestStorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "versionId", request.getVersionId());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call copyFileValidateBeforeCall(CopyFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'DestPath' is set
        if (request.getDestPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'DestPath' when calling copyFile");
        }
        
        // verify the required parameter 'SrcPath' is set
        if (request.getSrcPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'SrcPath' when calling copyFile");
        }
        

        com.squareup.okhttp.Call call = copyFileCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Copy file
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void copyFile(CopyFileRequest request) throws ApiException {
        try {
            copyFileWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                copyFileWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Copy file
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> copyFileWithHttpInfo(CopyFileRequest request) throws ApiException {
        com.squareup.okhttp.Call call = copyFileValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Copy file (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call copyFileAsync(CopyFileRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = copyFileValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for copyFolder
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call copyFolderCall(CopyFolderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/storage/folder/copy/{srcPath}"
            .replaceAll("\\{" + "srcPath" + "\\}", apiClient.escapeString(request.getSrcPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destPath", request.getDestPath());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "srcStorageName", request.getSrcStorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destStorageName", request.getDestStorageName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call copyFolderValidateBeforeCall(CopyFolderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'DestPath' is set
        if (request.getDestPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'DestPath' when calling copyFolder");
        }
        
        // verify the required parameter 'SrcPath' is set
        if (request.getSrcPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'SrcPath' when calling copyFolder");
        }
        

        com.squareup.okhttp.Call call = copyFolderCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Copy folder
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void copyFolder(CopyFolderRequest request) throws ApiException {
        try {
            copyFolderWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                copyFolderWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Copy folder
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> copyFolderWithHttpInfo(CopyFolderRequest request) throws ApiException {
        com.squareup.okhttp.Call call = copyFolderValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Copy folder (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call copyFolderAsync(CopyFolderRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = copyFolderValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for createDocument
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call createDocumentCall(CreateDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/create";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fileName", request.getFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createDocumentValidateBeforeCall(CreateDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = createDocumentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Creates new document. Document is created with format which is recognized from file extensions.  Supported extensions: \&quot;.doc\&quot;, \&quot;.docx\&quot;, \&quot;.docm\&quot;, \&quot;.dot\&quot;, \&quot;.dotm\&quot;, \&quot;.dotx\&quot;, \&quot;.flatopc\&quot;, \&quot;.fopc\&quot;, \&quot;.flatopc_macro\&quot;, \&quot;.fopc_macro\&quot;, \&quot;.flatopc_template\&quot;, \&quot;.fopc_template\&quot;, \&quot;.flatopc_template_macro\&quot;, \&quot;.fopc_template_macro\&quot;, \&quot;.wordml\&quot;, \&quot;.wml\&quot;, \&quot;.rtf\&quot;
     * 
     * @return DocumentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentResponse createDocument(CreateDocumentRequest request) throws ApiException {
        try {
            ApiResponse<DocumentResponse> resp = createDocumentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentResponse> resp = createDocumentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Creates new document. Document is created with format which is recognized from file extensions.  Supported extensions: \&quot;.doc\&quot;, \&quot;.docx\&quot;, \&quot;.docm\&quot;, \&quot;.dot\&quot;, \&quot;.dotm\&quot;, \&quot;.dotx\&quot;, \&quot;.flatopc\&quot;, \&quot;.fopc\&quot;, \&quot;.flatopc_macro\&quot;, \&quot;.fopc_macro\&quot;, \&quot;.flatopc_template\&quot;, \&quot;.fopc_template\&quot;, \&quot;.flatopc_template_macro\&quot;, \&quot;.fopc_template_macro\&quot;, \&quot;.wordml\&quot;, \&quot;.wml\&quot;, \&quot;.rtf\&quot;
     * 
     * @return ApiResponse&lt;DocumentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentResponse> createDocumentWithHttpInfo(CreateDocumentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = createDocumentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Creates new document. Document is created with format which is recognized from file extensions.  Supported extensions: \&quot;.doc\&quot;, \&quot;.docx\&quot;, \&quot;.docm\&quot;, \&quot;.dot\&quot;, \&quot;.dotm\&quot;, \&quot;.dotx\&quot;, \&quot;.flatopc\&quot;, \&quot;.fopc\&quot;, \&quot;.flatopc_macro\&quot;, \&quot;.fopc_macro\&quot;, \&quot;.flatopc_template\&quot;, \&quot;.fopc_template\&quot;, \&quot;.flatopc_template_macro\&quot;, \&quot;.fopc_template_macro\&quot;, \&quot;.wordml\&quot;, \&quot;.wml\&quot;, \&quot;.rtf\&quot; (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createDocumentAsync(CreateDocumentRequest request, final ApiCallback<DocumentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = createDocumentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for createFolder
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call createFolderCall(CreateFolderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/storage/folder/{path}"
            .replaceAll("\\{" + "path" + "\\}", apiClient.escapeString(request.getPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storageName", request.getStorageName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createFolderValidateBeforeCall(CreateFolderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Path' is set
        if (request.getPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Path' when calling createFolder");
        }
        

        com.squareup.okhttp.Call call = createFolderCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Create the folder
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void createFolder(CreateFolderRequest request) throws ApiException {
        try {
            createFolderWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                createFolderWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Create the folder
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> createFolderWithHttpInfo(CreateFolderRequest request) throws ApiException {
        com.squareup.okhttp.Call call = createFolderValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Create the folder (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createFolderAsync(CreateFolderRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = createFolderValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for createOrUpdateDocumentProperty
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call createOrUpdateDocumentPropertyCall(CreateOrUpdateDocumentPropertyRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getProperty();

        // create path and map variables
        String localVarPath = "/words/{name}/documentProperties/{propertyName}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "propertyName" + "\\}", apiClient.escapeString(request.getPropertyName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createOrUpdateDocumentPropertyValidateBeforeCall(CreateOrUpdateDocumentPropertyRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling createOrUpdateDocumentProperty");
        }
        
        // verify the required parameter 'PropertyName' is set
        if (request.getPropertyName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'PropertyName' when calling createOrUpdateDocumentProperty");
        }
        
        // verify the required parameter 'Property' is set
        if (request.getProperty() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Property' when calling createOrUpdateDocumentProperty");
        }
        

        com.squareup.okhttp.Call call = createOrUpdateDocumentPropertyCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds new or update existing document property.
     * 
     * @return DocumentPropertyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentPropertyResponse createOrUpdateDocumentProperty(CreateOrUpdateDocumentPropertyRequest request) throws ApiException {
        try {
            ApiResponse<DocumentPropertyResponse> resp = createOrUpdateDocumentPropertyWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentPropertyResponse> resp = createOrUpdateDocumentPropertyWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Adds new or update existing document property.
     * 
     * @return ApiResponse&lt;DocumentPropertyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentPropertyResponse> createOrUpdateDocumentPropertyWithHttpInfo(CreateOrUpdateDocumentPropertyRequest request) throws ApiException {
        com.squareup.okhttp.Call call = createOrUpdateDocumentPropertyValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentPropertyResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Adds new or update existing document property. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createOrUpdateDocumentPropertyAsync(CreateOrUpdateDocumentPropertyRequest request, final ApiCallback<DocumentPropertyResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = createOrUpdateDocumentPropertyValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentPropertyResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteBorder
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteBorderCall(DeleteBorderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/borders/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteBorderValidateBeforeCall(DeleteBorderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteBorder");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling deleteBorder");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling deleteBorder");
        }
        

        com.squareup.okhttp.Call call = deleteBorderCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Resets border properties to default values.             
     * &#39;nodePath&#39; should refer to node with cell or row
     * @return BorderResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public BorderResponse deleteBorder(DeleteBorderRequest request) throws ApiException {
        try {
            ApiResponse<BorderResponse> resp = deleteBorderWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<BorderResponse> resp = deleteBorderWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Resets border properties to default values.             
     * &#39;nodePath&#39; should refer to node with cell or row
     * @return ApiResponse&lt;BorderResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<BorderResponse> deleteBorderWithHttpInfo(DeleteBorderRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteBorderValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<BorderResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Resets border properties to default values.              (asynchronously)
     * &#39;nodePath&#39; should refer to node with cell or row
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteBorderAsync(DeleteBorderRequest request, final ApiCallback<BorderResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteBorderValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<BorderResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteBorders
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteBordersCall(DeleteBordersRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/borders"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteBordersValidateBeforeCall(DeleteBordersRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteBorders");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling deleteBorders");
        }
        

        com.squareup.okhttp.Call call = deleteBordersCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Resets borders properties to default values.             
     * &#39;nodePath&#39; should refer to node with cell or row
     * @return BordersResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public BordersResponse deleteBorders(DeleteBordersRequest request) throws ApiException {
        try {
            ApiResponse<BordersResponse> resp = deleteBordersWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<BordersResponse> resp = deleteBordersWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Resets borders properties to default values.             
     * &#39;nodePath&#39; should refer to node with cell or row
     * @return ApiResponse&lt;BordersResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<BordersResponse> deleteBordersWithHttpInfo(DeleteBordersRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteBordersValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<BordersResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Resets borders properties to default values.              (asynchronously)
     * &#39;nodePath&#39; should refer to node with cell or row
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteBordersAsync(DeleteBordersRequest request, final ApiCallback<BordersResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteBordersValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<BordersResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteComment
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteCommentCall(DeleteCommentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/comments/{commentIndex}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "commentIndex" + "\\}", apiClient.escapeString(request.getCommentIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteCommentValidateBeforeCall(DeleteCommentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteComment");
        }
        
        // verify the required parameter 'CommentIndex' is set
        if (request.getCommentIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'CommentIndex' when calling deleteComment");
        }
        

        com.squareup.okhttp.Call call = deleteCommentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Removes comment from document.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteComment(DeleteCommentRequest request) throws ApiException {
        try {
            deleteCommentWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteCommentWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Removes comment from document.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteCommentWithHttpInfo(DeleteCommentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteCommentValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Removes comment from document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteCommentAsync(DeleteCommentRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteCommentValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteDocumentProperty
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteDocumentPropertyCall(DeleteDocumentPropertyRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/documentProperties/{propertyName}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "propertyName" + "\\}", apiClient.escapeString(request.getPropertyName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteDocumentPropertyValidateBeforeCall(DeleteDocumentPropertyRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteDocumentProperty");
        }
        
        // verify the required parameter 'PropertyName' is set
        if (request.getPropertyName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'PropertyName' when calling deleteDocumentProperty");
        }
        

        com.squareup.okhttp.Call call = deleteDocumentPropertyCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes document property.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteDocumentProperty(DeleteDocumentPropertyRequest request) throws ApiException {
        try {
            deleteDocumentPropertyWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteDocumentPropertyWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Deletes document property.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteDocumentPropertyWithHttpInfo(DeleteDocumentPropertyRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteDocumentPropertyValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Deletes document property. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteDocumentPropertyAsync(DeleteDocumentPropertyRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteDocumentPropertyValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteDrawingObject
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteDrawingObjectCall(DeleteDrawingObjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/drawingObjects/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteDrawingObjectValidateBeforeCall(DeleteDrawingObjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteDrawingObject");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling deleteDrawingObject");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling deleteDrawingObject");
        }
        

        com.squareup.okhttp.Call call = deleteDrawingObjectCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Removes drawing object from document.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteDrawingObject(DeleteDrawingObjectRequest request) throws ApiException {
        try {
            deleteDrawingObjectWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteDrawingObjectWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Removes drawing object from document.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteDrawingObjectWithHttpInfo(DeleteDrawingObjectRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteDrawingObjectValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Removes drawing object from document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteDrawingObjectAsync(DeleteDrawingObjectRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteDrawingObjectValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteField
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteFieldCall(DeleteFieldRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/fields/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteFieldValidateBeforeCall(DeleteFieldRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteField");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling deleteField");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling deleteField");
        }
        

        com.squareup.okhttp.Call call = deleteFieldCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes field from document.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteField(DeleteFieldRequest request) throws ApiException {
        try {
            deleteFieldWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteFieldWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Deletes field from document.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteFieldWithHttpInfo(DeleteFieldRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteFieldValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Deletes field from document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteFieldAsync(DeleteFieldRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteFieldValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteFields
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteFieldsCall(DeleteFieldsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/fields"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteFieldsValidateBeforeCall(DeleteFieldsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteFields");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling deleteFields");
        }
        

        com.squareup.okhttp.Call call = deleteFieldsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Removes fields from section paragraph.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteFields(DeleteFieldsRequest request) throws ApiException {
        try {
            deleteFieldsWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteFieldsWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Removes fields from section paragraph.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteFieldsWithHttpInfo(DeleteFieldsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteFieldsValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Removes fields from section paragraph. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteFieldsAsync(DeleteFieldsRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteFieldsValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteFile
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteFileCall(DeleteFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/storage/file/{path}"
            .replaceAll("\\{" + "path" + "\\}", apiClient.escapeString(request.getPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storageName", request.getStorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "versionId", request.getVersionId());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteFileValidateBeforeCall(DeleteFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Path' is set
        if (request.getPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Path' when calling deleteFile");
        }
        

        com.squareup.okhttp.Call call = deleteFileCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete file
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteFile(DeleteFileRequest request) throws ApiException {
        try {
            deleteFileWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteFileWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Delete file
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteFileWithHttpInfo(DeleteFileRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteFileValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete file (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteFileAsync(DeleteFileRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteFileValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteFolder
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteFolderCall(DeleteFolderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/storage/folder/{path}"
            .replaceAll("\\{" + "path" + "\\}", apiClient.escapeString(request.getPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storageName", request.getStorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "recursive", request.getRecursive());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteFolderValidateBeforeCall(DeleteFolderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Path' is set
        if (request.getPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Path' when calling deleteFolder");
        }
        

        com.squareup.okhttp.Call call = deleteFolderCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete folder
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteFolder(DeleteFolderRequest request) throws ApiException {
        try {
            deleteFolderWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteFolderWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Delete folder
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteFolderWithHttpInfo(DeleteFolderRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteFolderValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete folder (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteFolderAsync(DeleteFolderRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteFolderValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteFootnote
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteFootnoteCall(DeleteFootnoteRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/footnotes/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteFootnoteValidateBeforeCall(DeleteFootnoteRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteFootnote");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling deleteFootnote");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling deleteFootnote");
        }
        

        com.squareup.okhttp.Call call = deleteFootnoteCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Removes footnote from document.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteFootnote(DeleteFootnoteRequest request) throws ApiException {
        try {
            deleteFootnoteWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteFootnoteWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Removes footnote from document.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteFootnoteWithHttpInfo(DeleteFootnoteRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteFootnoteValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Removes footnote from document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteFootnoteAsync(DeleteFootnoteRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteFootnoteValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteFormField
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteFormFieldCall(DeleteFormFieldRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/formfields/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteFormFieldValidateBeforeCall(DeleteFormFieldRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteFormField");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling deleteFormField");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling deleteFormField");
        }
        

        com.squareup.okhttp.Call call = deleteFormFieldCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Removes form field from document.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteFormField(DeleteFormFieldRequest request) throws ApiException {
        try {
            deleteFormFieldWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteFormFieldWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Removes form field from document.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteFormFieldWithHttpInfo(DeleteFormFieldRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteFormFieldValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Removes form field from document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteFormFieldAsync(DeleteFormFieldRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteFormFieldValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteHeaderFooter
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteHeaderFooterCall(DeleteHeaderFooterRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{sectionPath}/headersfooters/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "sectionPath" + "\\}", apiClient.escapeString(request.getSectionPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteHeaderFooterValidateBeforeCall(DeleteHeaderFooterRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteHeaderFooter");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling deleteHeaderFooter");
        }
        
        // verify the required parameter 'SectionPath' is set
        if (request.getSectionPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'SectionPath' when calling deleteHeaderFooter");
        }
        

        com.squareup.okhttp.Call call = deleteHeaderFooterCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes header/footer from document.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteHeaderFooter(DeleteHeaderFooterRequest request) throws ApiException {
        try {
            deleteHeaderFooterWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteHeaderFooterWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Deletes header/footer from document.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteHeaderFooterWithHttpInfo(DeleteHeaderFooterRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteHeaderFooterValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Deletes header/footer from document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteHeaderFooterAsync(DeleteHeaderFooterRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteHeaderFooterValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteHeadersFooters
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteHeadersFootersCall(DeleteHeadersFootersRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{sectionPath}/headersfooters"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "sectionPath" + "\\}", apiClient.escapeString(request.getSectionPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "headersFootersTypes", request.getHeadersFootersTypes());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteHeadersFootersValidateBeforeCall(DeleteHeadersFootersRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteHeadersFooters");
        }
        
        // verify the required parameter 'SectionPath' is set
        if (request.getSectionPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'SectionPath' when calling deleteHeadersFooters");
        }
        

        com.squareup.okhttp.Call call = deleteHeadersFootersCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes document headers and footers.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteHeadersFooters(DeleteHeadersFootersRequest request) throws ApiException {
        try {
            deleteHeadersFootersWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteHeadersFootersWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Deletes document headers and footers.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteHeadersFootersWithHttpInfo(DeleteHeadersFootersRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteHeadersFootersValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Deletes document headers and footers. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteHeadersFootersAsync(DeleteHeadersFootersRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteHeadersFootersValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteMacros
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteMacrosCall(DeleteMacrosRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/macros"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteMacrosValidateBeforeCall(DeleteMacrosRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteMacros");
        }
        

        com.squareup.okhttp.Call call = deleteMacrosCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Removes macros from document.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteMacros(DeleteMacrosRequest request) throws ApiException {
        try {
            deleteMacrosWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteMacrosWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Removes macros from document.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteMacrosWithHttpInfo(DeleteMacrosRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteMacrosValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Removes macros from document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteMacrosAsync(DeleteMacrosRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteMacrosValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteOfficeMathObject
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteOfficeMathObjectCall(DeleteOfficeMathObjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/OfficeMathObjects/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteOfficeMathObjectValidateBeforeCall(DeleteOfficeMathObjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteOfficeMathObject");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling deleteOfficeMathObject");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling deleteOfficeMathObject");
        }
        

        com.squareup.okhttp.Call call = deleteOfficeMathObjectCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Removes OfficeMath object from document.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteOfficeMathObject(DeleteOfficeMathObjectRequest request) throws ApiException {
        try {
            deleteOfficeMathObjectWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteOfficeMathObjectWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Removes OfficeMath object from document.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteOfficeMathObjectWithHttpInfo(DeleteOfficeMathObjectRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteOfficeMathObjectValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Removes OfficeMath object from document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteOfficeMathObjectAsync(DeleteOfficeMathObjectRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteOfficeMathObjectValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteParagraph
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteParagraphCall(DeleteParagraphRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/paragraphs/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteParagraphValidateBeforeCall(DeleteParagraphRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteParagraph");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling deleteParagraph");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling deleteParagraph");
        }
        

        com.squareup.okhttp.Call call = deleteParagraphCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Removes paragraph from section.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteParagraph(DeleteParagraphRequest request) throws ApiException {
        try {
            deleteParagraphWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteParagraphWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Removes paragraph from section.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteParagraphWithHttpInfo(DeleteParagraphRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteParagraphValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Removes paragraph from section. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteParagraphAsync(DeleteParagraphRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteParagraphValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteRun
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteRunCall(DeleteRunRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{paragraphPath}/runs/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "paragraphPath" + "\\}", apiClient.escapeString(request.getParagraphPath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteRunValidateBeforeCall(DeleteRunRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteRun");
        }
        
        // verify the required parameter 'ParagraphPath' is set
        if (request.getParagraphPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'ParagraphPath' when calling deleteRun");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling deleteRun");
        }
        

        com.squareup.okhttp.Call call = deleteRunCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Removes run from document.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteRun(DeleteRunRequest request) throws ApiException {
        try {
            deleteRunWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteRunWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Removes run from document.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteRunWithHttpInfo(DeleteRunRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteRunValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Removes run from document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteRunAsync(DeleteRunRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteRunValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteTable
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteTableCall(DeleteTableRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/tables/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteTableValidateBeforeCall(DeleteTableRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteTable");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling deleteTable");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling deleteTable");
        }
        

        com.squareup.okhttp.Call call = deleteTableCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes a table.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteTable(DeleteTableRequest request) throws ApiException {
        try {
            deleteTableWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteTableWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Deletes a table.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteTableWithHttpInfo(DeleteTableRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteTableValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Deletes a table. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteTableAsync(DeleteTableRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteTableValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteTableCell
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteTableCellCall(DeleteTableCellRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{tableRowPath}/cells/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "tableRowPath" + "\\}", apiClient.escapeString(request.getTableRowPath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteTableCellValidateBeforeCall(DeleteTableCellRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteTableCell");
        }
        
        // verify the required parameter 'TableRowPath' is set
        if (request.getTableRowPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'TableRowPath' when calling deleteTableCell");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling deleteTableCell");
        }
        

        com.squareup.okhttp.Call call = deleteTableCellCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes a table cell.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteTableCell(DeleteTableCellRequest request) throws ApiException {
        try {
            deleteTableCellWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteTableCellWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Deletes a table cell.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteTableCellWithHttpInfo(DeleteTableCellRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteTableCellValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Deletes a table cell. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteTableCellAsync(DeleteTableCellRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteTableCellValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteTableRow
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteTableRowCall(DeleteTableRowRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{tablePath}/rows/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "tablePath" + "\\}", apiClient.escapeString(request.getTablePath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteTableRowValidateBeforeCall(DeleteTableRowRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteTableRow");
        }
        
        // verify the required parameter 'TablePath' is set
        if (request.getTablePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'TablePath' when calling deleteTableRow");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling deleteTableRow");
        }
        

        com.squareup.okhttp.Call call = deleteTableRowCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes a table row.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteTableRow(DeleteTableRowRequest request) throws ApiException {
        try {
            deleteTableRowWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                deleteTableRowWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Deletes a table row.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> deleteTableRowWithHttpInfo(DeleteTableRowRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteTableRowValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Deletes a table row. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteTableRowAsync(DeleteTableRowRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteTableRowValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteWatermark
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call deleteWatermarkCall(DeleteWatermarkRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/watermarks/deleteLast"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteWatermarkValidateBeforeCall(DeleteWatermarkRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling deleteWatermark");
        }
        

        com.squareup.okhttp.Call call = deleteWatermarkCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes watermark (for deleting last watermark from the document).
     * 
     * @return DocumentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentResponse deleteWatermark(DeleteWatermarkRequest request) throws ApiException {
        try {
            ApiResponse<DocumentResponse> resp = deleteWatermarkWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentResponse> resp = deleteWatermarkWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Deletes watermark (for deleting last watermark from the document).
     * 
     * @return ApiResponse&lt;DocumentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentResponse> deleteWatermarkWithHttpInfo(DeleteWatermarkRequest request) throws ApiException {
        com.squareup.okhttp.Call call = deleteWatermarkValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Deletes watermark (for deleting last watermark from the document). (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteWatermarkAsync(DeleteWatermarkRequest request, final ApiCallback<DocumentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteWatermarkValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for downloadFile
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call downloadFileCall(DownloadFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/storage/file/{path}"
            .replaceAll("\\{" + "path" + "\\}", apiClient.escapeString(request.getPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storageName", request.getStorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "versionId", request.getVersionId());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call downloadFileValidateBeforeCall(DownloadFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Path' is set
        if (request.getPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Path' when calling downloadFile");
        }
        

        com.squareup.okhttp.Call call = downloadFileCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Download file
     * 
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File downloadFile(DownloadFileRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = downloadFileWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = downloadFileWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Download file
     * 
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> downloadFileWithHttpInfo(DownloadFileRequest request) throws ApiException {
        com.squareup.okhttp.Call call = downloadFileValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Download file (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call downloadFileAsync(DownloadFileRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = downloadFileValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for executeMailMerge
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call executeMailMergeCall(ExecuteMailMergeRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/executeMailMerge"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "withRegions", request.getWithRegions());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "mailMergeDataFile", request.getMailMergeDataFile());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "cleanup", request.getCleanup());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "useWholeParagraphAsRegion", request.getUseWholeParagraphAsRegion());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        if (request.getData() != null)
          localVarFormParams.put("Data", request.getData());

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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call executeMailMergeValidateBeforeCall(ExecuteMailMergeRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling executeMailMerge");
        }
        

        com.squareup.okhttp.Call call = executeMailMergeCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Executes document mail merge operation.
     * 
     * @return DocumentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentResponse executeMailMerge(ExecuteMailMergeRequest request) throws ApiException {
        try {
            ApiResponse<DocumentResponse> resp = executeMailMergeWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentResponse> resp = executeMailMergeWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Executes document mail merge operation.
     * 
     * @return ApiResponse&lt;DocumentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentResponse> executeMailMergeWithHttpInfo(ExecuteMailMergeRequest request) throws ApiException {
        com.squareup.okhttp.Call call = executeMailMergeValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Executes document mail merge operation. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call executeMailMergeAsync(ExecuteMailMergeRequest request, final ApiCallback<DocumentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = executeMailMergeValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for executeMailMergeOnline
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call executeMailMergeOnlineCall(ExecuteMailMergeOnlineRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/executeMailMerge";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "withRegions", request.getWithRegions());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "cleanup", request.getCleanup());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "documentFileName", request.getDocumentFileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        if (request.getTemplate() != null)
          localVarFormParams.put("Template", request.getTemplate());
if (request.getData() != null)
          localVarFormParams.put("Data", request.getData());

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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call executeMailMergeOnlineValidateBeforeCall(ExecuteMailMergeOnlineRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Template' is set
        if (request.getTemplate() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Template' when calling executeMailMergeOnline");
        }
        
        // verify the required parameter 'Data' is set
        if (request.getData() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Data' when calling executeMailMergeOnline");
        }
        

        com.squareup.okhttp.Call call = executeMailMergeOnlineCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Executes document mail merge online.
     * 
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File executeMailMergeOnline(ExecuteMailMergeOnlineRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = executeMailMergeOnlineWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = executeMailMergeOnlineWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Executes document mail merge online.
     * 
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> executeMailMergeOnlineWithHttpInfo(ExecuteMailMergeOnlineRequest request) throws ApiException {
        com.squareup.okhttp.Call call = executeMailMergeOnlineValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Executes document mail merge online. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call executeMailMergeOnlineAsync(ExecuteMailMergeOnlineRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = executeMailMergeOnlineValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for executeTemplate
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call executeTemplateCall(ExecuteTemplateRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/executeTemplate"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "cleanup", request.getCleanup());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "useWholeParagraphAsRegion", request.getUseWholeParagraphAsRegion());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "withRegions", request.getWithRegions());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        if (request.getData() != null)
          localVarFormParams.put("Data", request.getData());

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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call executeTemplateValidateBeforeCall(ExecuteTemplateRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling executeTemplate");
        }
        
        // verify the required parameter 'Data' is set
        if (request.getData() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Data' when calling executeTemplate");
        }
        

        com.squareup.okhttp.Call call = executeTemplateCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Populates document template with data.
     * 
     * @return DocumentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentResponse executeTemplate(ExecuteTemplateRequest request) throws ApiException {
        try {
            ApiResponse<DocumentResponse> resp = executeTemplateWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentResponse> resp = executeTemplateWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Populates document template with data.
     * 
     * @return ApiResponse&lt;DocumentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentResponse> executeTemplateWithHttpInfo(ExecuteTemplateRequest request) throws ApiException {
        com.squareup.okhttp.Call call = executeTemplateValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Populates document template with data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call executeTemplateAsync(ExecuteTemplateRequest request, final ApiCallback<DocumentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = executeTemplateValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for executeTemplateOnline
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call executeTemplateOnlineCall(ExecuteTemplateOnlineRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/executeTemplate";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "cleanup", request.getCleanup());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "useWholeParagraphAsRegion", request.getUseWholeParagraphAsRegion());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "withRegions", request.getWithRegions());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "documentFileName", request.getDocumentFileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        if (request.getTemplate() != null)
          localVarFormParams.put("Template", request.getTemplate());
if (request.getData() != null)
          localVarFormParams.put("Data", request.getData());

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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call executeTemplateOnlineValidateBeforeCall(ExecuteTemplateOnlineRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Template' is set
        if (request.getTemplate() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Template' when calling executeTemplateOnline");
        }
        
        // verify the required parameter 'Data' is set
        if (request.getData() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Data' when calling executeTemplateOnline");
        }
        

        com.squareup.okhttp.Call call = executeTemplateOnlineCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Populates document template with data online.
     * 
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File executeTemplateOnline(ExecuteTemplateOnlineRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = executeTemplateOnlineWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = executeTemplateOnlineWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Populates document template with data online.
     * 
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> executeTemplateOnlineWithHttpInfo(ExecuteTemplateOnlineRequest request) throws ApiException {
        com.squareup.okhttp.Call call = executeTemplateOnlineValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Populates document template with data online. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call executeTemplateOnlineAsync(ExecuteTemplateOnlineRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = executeTemplateOnlineValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getAvailableFonts
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getAvailableFontsCall(GetAvailableFontsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/fonts/available";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fontsLocation", request.getFontsLocation());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAvailableFontsValidateBeforeCall(GetAvailableFontsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = getAvailableFontsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Gets the list of fonts, available for document processing
     * 
     * @return AvailableFontsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AvailableFontsResponse getAvailableFonts(GetAvailableFontsRequest request) throws ApiException {
        try {
            ApiResponse<AvailableFontsResponse> resp = getAvailableFontsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<AvailableFontsResponse> resp = getAvailableFontsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Gets the list of fonts, available for document processing
     * 
     * @return ApiResponse&lt;AvailableFontsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AvailableFontsResponse> getAvailableFontsWithHttpInfo(GetAvailableFontsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getAvailableFontsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<AvailableFontsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets the list of fonts, available for document processing (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAvailableFontsAsync(GetAvailableFontsRequest request, final ApiCallback<AvailableFontsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getAvailableFontsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AvailableFontsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getBookmarkByName
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getBookmarkByNameCall(GetBookmarkByNameRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/bookmarks/{bookmarkName}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "bookmarkName" + "\\}", apiClient.escapeString(request.getBookmarkName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getBookmarkByNameValidateBeforeCall(GetBookmarkByNameRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getBookmarkByName");
        }
        
        // verify the required parameter 'BookmarkName' is set
        if (request.getBookmarkName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'BookmarkName' when calling getBookmarkByName");
        }
        

        com.squareup.okhttp.Call call = getBookmarkByNameCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reads document bookmark data by its name.
     * 
     * @return BookmarkResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public BookmarkResponse getBookmarkByName(GetBookmarkByNameRequest request) throws ApiException {
        try {
            ApiResponse<BookmarkResponse> resp = getBookmarkByNameWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<BookmarkResponse> resp = getBookmarkByNameWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reads document bookmark data by its name.
     * 
     * @return ApiResponse&lt;BookmarkResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<BookmarkResponse> getBookmarkByNameWithHttpInfo(GetBookmarkByNameRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getBookmarkByNameValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<BookmarkResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reads document bookmark data by its name. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getBookmarkByNameAsync(GetBookmarkByNameRequest request, final ApiCallback<BookmarkResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getBookmarkByNameValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<BookmarkResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getBookmarks
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getBookmarksCall(GetBookmarksRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/bookmarks"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getBookmarksValidateBeforeCall(GetBookmarksRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getBookmarks");
        }
        

        com.squareup.okhttp.Call call = getBookmarksCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reads document bookmarks common info.
     * 
     * @return BookmarksResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public BookmarksResponse getBookmarks(GetBookmarksRequest request) throws ApiException {
        try {
            ApiResponse<BookmarksResponse> resp = getBookmarksWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<BookmarksResponse> resp = getBookmarksWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reads document bookmarks common info.
     * 
     * @return ApiResponse&lt;BookmarksResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<BookmarksResponse> getBookmarksWithHttpInfo(GetBookmarksRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getBookmarksValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<BookmarksResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reads document bookmarks common info. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getBookmarksAsync(GetBookmarksRequest request, final ApiCallback<BookmarksResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getBookmarksValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<BookmarksResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getBorder
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getBorderCall(GetBorderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/borders/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getBorderValidateBeforeCall(GetBorderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getBorder");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getBorder");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getBorder");
        }
        

        com.squareup.okhttp.Call call = getBorderCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a border.
     * &#39;nodePath&#39; should refer to node with cell or row
     * @return BorderResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public BorderResponse getBorder(GetBorderRequest request) throws ApiException {
        try {
            ApiResponse<BorderResponse> resp = getBorderWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<BorderResponse> resp = getBorderWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns a border.
     * &#39;nodePath&#39; should refer to node with cell or row
     * @return ApiResponse&lt;BorderResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<BorderResponse> getBorderWithHttpInfo(GetBorderRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getBorderValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<BorderResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a border. (asynchronously)
     * &#39;nodePath&#39; should refer to node with cell or row
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getBorderAsync(GetBorderRequest request, final ApiCallback<BorderResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getBorderValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<BorderResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getBorders
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getBordersCall(GetBordersRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/borders"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getBordersValidateBeforeCall(GetBordersRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getBorders");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getBorders");
        }
        

        com.squareup.okhttp.Call call = getBordersCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a collection of borders.
     * &#39;nodePath&#39; should refer to node with cell or row
     * @return BordersResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public BordersResponse getBorders(GetBordersRequest request) throws ApiException {
        try {
            ApiResponse<BordersResponse> resp = getBordersWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<BordersResponse> resp = getBordersWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns a collection of borders.
     * &#39;nodePath&#39; should refer to node with cell or row
     * @return ApiResponse&lt;BordersResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<BordersResponse> getBordersWithHttpInfo(GetBordersRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getBordersValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<BordersResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a collection of borders. (asynchronously)
     * &#39;nodePath&#39; should refer to node with cell or row
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getBordersAsync(GetBordersRequest request, final ApiCallback<BordersResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getBordersValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<BordersResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getComment
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getCommentCall(GetCommentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/comments/{commentIndex}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "commentIndex" + "\\}", apiClient.escapeString(request.getCommentIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCommentValidateBeforeCall(GetCommentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getComment");
        }
        
        // verify the required parameter 'CommentIndex' is set
        if (request.getCommentIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'CommentIndex' when calling getComment");
        }
        

        com.squareup.okhttp.Call call = getCommentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Gets comment from document.
     * 
     * @return CommentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CommentResponse getComment(GetCommentRequest request) throws ApiException {
        try {
            ApiResponse<CommentResponse> resp = getCommentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<CommentResponse> resp = getCommentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Gets comment from document.
     * 
     * @return ApiResponse&lt;CommentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<CommentResponse> getCommentWithHttpInfo(GetCommentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getCommentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<CommentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets comment from document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCommentAsync(GetCommentRequest request, final ApiCallback<CommentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCommentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CommentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getComments
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getCommentsCall(GetCommentsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/comments"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCommentsValidateBeforeCall(GetCommentsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getComments");
        }
        

        com.squareup.okhttp.Call call = getCommentsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Gets comments from document.
     * 
     * @return CommentsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CommentsResponse getComments(GetCommentsRequest request) throws ApiException {
        try {
            ApiResponse<CommentsResponse> resp = getCommentsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<CommentsResponse> resp = getCommentsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Gets comments from document.
     * 
     * @return ApiResponse&lt;CommentsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<CommentsResponse> getCommentsWithHttpInfo(GetCommentsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getCommentsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<CommentsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets comments from document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCommentsAsync(GetCommentsRequest request, final ApiCallback<CommentsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCommentsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CommentsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDocument
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDocumentCall(GetDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{documentName}"
            .replaceAll("\\{" + "documentName" + "\\}", apiClient.escapeString(request.getDocumentName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDocumentValidateBeforeCall(GetDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'DocumentName' is set
        if (request.getDocumentName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'DocumentName' when calling getDocument");
        }
        

        com.squareup.okhttp.Call call = getDocumentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reads document common info.
     * 
     * @return DocumentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentResponse getDocument(GetDocumentRequest request) throws ApiException {
        try {
            ApiResponse<DocumentResponse> resp = getDocumentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentResponse> resp = getDocumentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reads document common info.
     * 
     * @return ApiResponse&lt;DocumentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentResponse> getDocumentWithHttpInfo(GetDocumentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDocumentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reads document common info. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDocumentAsync(GetDocumentRequest request, final ApiCallback<DocumentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDocumentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDocumentDrawingObjectByIndex
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDocumentDrawingObjectByIndexCall(GetDocumentDrawingObjectByIndexRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/drawingObjects/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDocumentDrawingObjectByIndexValidateBeforeCall(GetDocumentDrawingObjectByIndexRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getDocumentDrawingObjectByIndex");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getDocumentDrawingObjectByIndex");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getDocumentDrawingObjectByIndex");
        }
        

        com.squareup.okhttp.Call call = getDocumentDrawingObjectByIndexCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reads document drawing object common info by its index or convert to format specified.
     * 
     * @return DrawingObjectResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DrawingObjectResponse getDocumentDrawingObjectByIndex(GetDocumentDrawingObjectByIndexRequest request) throws ApiException {
        try {
            ApiResponse<DrawingObjectResponse> resp = getDocumentDrawingObjectByIndexWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DrawingObjectResponse> resp = getDocumentDrawingObjectByIndexWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reads document drawing object common info by its index or convert to format specified.
     * 
     * @return ApiResponse&lt;DrawingObjectResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DrawingObjectResponse> getDocumentDrawingObjectByIndexWithHttpInfo(GetDocumentDrawingObjectByIndexRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDocumentDrawingObjectByIndexValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DrawingObjectResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reads document drawing object common info by its index or convert to format specified. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDocumentDrawingObjectByIndexAsync(GetDocumentDrawingObjectByIndexRequest request, final ApiCallback<DrawingObjectResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDocumentDrawingObjectByIndexValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DrawingObjectResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDocumentDrawingObjectImageData
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDocumentDrawingObjectImageDataCall(GetDocumentDrawingObjectImageDataRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/drawingObjects/{index}/imageData"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDocumentDrawingObjectImageDataValidateBeforeCall(GetDocumentDrawingObjectImageDataRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getDocumentDrawingObjectImageData");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getDocumentDrawingObjectImageData");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getDocumentDrawingObjectImageData");
        }
        

        com.squareup.okhttp.Call call = getDocumentDrawingObjectImageDataCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reads drawing object image data.
     * 
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File getDocumentDrawingObjectImageData(GetDocumentDrawingObjectImageDataRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = getDocumentDrawingObjectImageDataWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = getDocumentDrawingObjectImageDataWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reads drawing object image data.
     * 
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> getDocumentDrawingObjectImageDataWithHttpInfo(GetDocumentDrawingObjectImageDataRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDocumentDrawingObjectImageDataValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reads drawing object image data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDocumentDrawingObjectImageDataAsync(GetDocumentDrawingObjectImageDataRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDocumentDrawingObjectImageDataValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDocumentDrawingObjectOleData
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDocumentDrawingObjectOleDataCall(GetDocumentDrawingObjectOleDataRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/drawingObjects/{index}/oleData"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDocumentDrawingObjectOleDataValidateBeforeCall(GetDocumentDrawingObjectOleDataRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getDocumentDrawingObjectOleData");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getDocumentDrawingObjectOleData");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getDocumentDrawingObjectOleData");
        }
        

        com.squareup.okhttp.Call call = getDocumentDrawingObjectOleDataCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Gets drawing object OLE data.
     * 
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File getDocumentDrawingObjectOleData(GetDocumentDrawingObjectOleDataRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = getDocumentDrawingObjectOleDataWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = getDocumentDrawingObjectOleDataWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Gets drawing object OLE data.
     * 
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> getDocumentDrawingObjectOleDataWithHttpInfo(GetDocumentDrawingObjectOleDataRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDocumentDrawingObjectOleDataValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets drawing object OLE data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDocumentDrawingObjectOleDataAsync(GetDocumentDrawingObjectOleDataRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDocumentDrawingObjectOleDataValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDocumentDrawingObjects
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDocumentDrawingObjectsCall(GetDocumentDrawingObjectsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/drawingObjects"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDocumentDrawingObjectsValidateBeforeCall(GetDocumentDrawingObjectsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getDocumentDrawingObjects");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getDocumentDrawingObjects");
        }
        

        com.squareup.okhttp.Call call = getDocumentDrawingObjectsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reads document drawing objects common info.
     * 
     * @return DrawingObjectsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DrawingObjectsResponse getDocumentDrawingObjects(GetDocumentDrawingObjectsRequest request) throws ApiException {
        try {
            ApiResponse<DrawingObjectsResponse> resp = getDocumentDrawingObjectsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DrawingObjectsResponse> resp = getDocumentDrawingObjectsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reads document drawing objects common info.
     * 
     * @return ApiResponse&lt;DrawingObjectsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DrawingObjectsResponse> getDocumentDrawingObjectsWithHttpInfo(GetDocumentDrawingObjectsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDocumentDrawingObjectsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DrawingObjectsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reads document drawing objects common info. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDocumentDrawingObjectsAsync(GetDocumentDrawingObjectsRequest request, final ApiCallback<DrawingObjectsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDocumentDrawingObjectsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DrawingObjectsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDocumentFieldNames
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDocumentFieldNamesCall(GetDocumentFieldNamesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/mailMergeFieldNames"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "useNonMergeFields", request.getUseNonMergeFields());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDocumentFieldNamesValidateBeforeCall(GetDocumentFieldNamesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getDocumentFieldNames");
        }
        

        com.squareup.okhttp.Call call = getDocumentFieldNamesCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reads document field names.
     * 
     * @return FieldNamesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FieldNamesResponse getDocumentFieldNames(GetDocumentFieldNamesRequest request) throws ApiException {
        try {
            ApiResponse<FieldNamesResponse> resp = getDocumentFieldNamesWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FieldNamesResponse> resp = getDocumentFieldNamesWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reads document field names.
     * 
     * @return ApiResponse&lt;FieldNamesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FieldNamesResponse> getDocumentFieldNamesWithHttpInfo(GetDocumentFieldNamesRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDocumentFieldNamesValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FieldNamesResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reads document field names. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDocumentFieldNamesAsync(GetDocumentFieldNamesRequest request, final ApiCallback<FieldNamesResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDocumentFieldNamesValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FieldNamesResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDocumentFieldNamesOnline
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDocumentFieldNamesOnlineCall(GetDocumentFieldNamesOnlineRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/mailMergeFieldNames";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "useNonMergeFields", request.getUseNonMergeFields());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        if (request.getTemplate() != null)
          localVarFormParams.put("Template", request.getTemplate());

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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDocumentFieldNamesOnlineValidateBeforeCall(GetDocumentFieldNamesOnlineRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Template' is set
        if (request.getTemplate() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Template' when calling getDocumentFieldNamesOnline");
        }
        

        com.squareup.okhttp.Call call = getDocumentFieldNamesOnlineCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reads document field names.
     * 
     * @return FieldNamesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FieldNamesResponse getDocumentFieldNamesOnline(GetDocumentFieldNamesOnlineRequest request) throws ApiException {
        try {
            ApiResponse<FieldNamesResponse> resp = getDocumentFieldNamesOnlineWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FieldNamesResponse> resp = getDocumentFieldNamesOnlineWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reads document field names.
     * 
     * @return ApiResponse&lt;FieldNamesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FieldNamesResponse> getDocumentFieldNamesOnlineWithHttpInfo(GetDocumentFieldNamesOnlineRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDocumentFieldNamesOnlineValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FieldNamesResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reads document field names. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDocumentFieldNamesOnlineAsync(GetDocumentFieldNamesOnlineRequest request, final ApiCallback<FieldNamesResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDocumentFieldNamesOnlineValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FieldNamesResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDocumentHyperlinkByIndex
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDocumentHyperlinkByIndexCall(GetDocumentHyperlinkByIndexRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/hyperlinks/{hyperlinkIndex}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "hyperlinkIndex" + "\\}", apiClient.escapeString(request.getHyperlinkIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDocumentHyperlinkByIndexValidateBeforeCall(GetDocumentHyperlinkByIndexRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getDocumentHyperlinkByIndex");
        }
        
        // verify the required parameter 'HyperlinkIndex' is set
        if (request.getHyperlinkIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'HyperlinkIndex' when calling getDocumentHyperlinkByIndex");
        }
        

        com.squareup.okhttp.Call call = getDocumentHyperlinkByIndexCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reads document hyperlink by its index.
     * 
     * @return HyperlinkResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public HyperlinkResponse getDocumentHyperlinkByIndex(GetDocumentHyperlinkByIndexRequest request) throws ApiException {
        try {
            ApiResponse<HyperlinkResponse> resp = getDocumentHyperlinkByIndexWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<HyperlinkResponse> resp = getDocumentHyperlinkByIndexWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reads document hyperlink by its index.
     * 
     * @return ApiResponse&lt;HyperlinkResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<HyperlinkResponse> getDocumentHyperlinkByIndexWithHttpInfo(GetDocumentHyperlinkByIndexRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDocumentHyperlinkByIndexValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<HyperlinkResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reads document hyperlink by its index. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDocumentHyperlinkByIndexAsync(GetDocumentHyperlinkByIndexRequest request, final ApiCallback<HyperlinkResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDocumentHyperlinkByIndexValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<HyperlinkResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDocumentHyperlinks
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDocumentHyperlinksCall(GetDocumentHyperlinksRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/hyperlinks"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDocumentHyperlinksValidateBeforeCall(GetDocumentHyperlinksRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getDocumentHyperlinks");
        }
        

        com.squareup.okhttp.Call call = getDocumentHyperlinksCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reads document hyperlinks common info.
     * 
     * @return HyperlinksResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public HyperlinksResponse getDocumentHyperlinks(GetDocumentHyperlinksRequest request) throws ApiException {
        try {
            ApiResponse<HyperlinksResponse> resp = getDocumentHyperlinksWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<HyperlinksResponse> resp = getDocumentHyperlinksWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reads document hyperlinks common info.
     * 
     * @return ApiResponse&lt;HyperlinksResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<HyperlinksResponse> getDocumentHyperlinksWithHttpInfo(GetDocumentHyperlinksRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDocumentHyperlinksValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<HyperlinksResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reads document hyperlinks common info. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDocumentHyperlinksAsync(GetDocumentHyperlinksRequest request, final ApiCallback<HyperlinksResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDocumentHyperlinksValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<HyperlinksResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDocumentProperties
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDocumentPropertiesCall(GetDocumentPropertiesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/documentProperties"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDocumentPropertiesValidateBeforeCall(GetDocumentPropertiesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getDocumentProperties");
        }
        

        com.squareup.okhttp.Call call = getDocumentPropertiesCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reads document properties info.
     * 
     * @return DocumentPropertiesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentPropertiesResponse getDocumentProperties(GetDocumentPropertiesRequest request) throws ApiException {
        try {
            ApiResponse<DocumentPropertiesResponse> resp = getDocumentPropertiesWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentPropertiesResponse> resp = getDocumentPropertiesWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reads document properties info.
     * 
     * @return ApiResponse&lt;DocumentPropertiesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentPropertiesResponse> getDocumentPropertiesWithHttpInfo(GetDocumentPropertiesRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDocumentPropertiesValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentPropertiesResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reads document properties info. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDocumentPropertiesAsync(GetDocumentPropertiesRequest request, final ApiCallback<DocumentPropertiesResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDocumentPropertiesValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentPropertiesResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDocumentProperty
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDocumentPropertyCall(GetDocumentPropertyRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/documentProperties/{propertyName}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "propertyName" + "\\}", apiClient.escapeString(request.getPropertyName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDocumentPropertyValidateBeforeCall(GetDocumentPropertyRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getDocumentProperty");
        }
        
        // verify the required parameter 'PropertyName' is set
        if (request.getPropertyName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'PropertyName' when calling getDocumentProperty");
        }
        

        com.squareup.okhttp.Call call = getDocumentPropertyCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reads document property info by the property name.
     * 
     * @return DocumentPropertyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentPropertyResponse getDocumentProperty(GetDocumentPropertyRequest request) throws ApiException {
        try {
            ApiResponse<DocumentPropertyResponse> resp = getDocumentPropertyWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentPropertyResponse> resp = getDocumentPropertyWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reads document property info by the property name.
     * 
     * @return ApiResponse&lt;DocumentPropertyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentPropertyResponse> getDocumentPropertyWithHttpInfo(GetDocumentPropertyRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDocumentPropertyValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentPropertyResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reads document property info by the property name. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDocumentPropertyAsync(GetDocumentPropertyRequest request, final ApiCallback<DocumentPropertyResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDocumentPropertyValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentPropertyResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDocumentProtection
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDocumentProtectionCall(GetDocumentProtectionRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/protection"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDocumentProtectionValidateBeforeCall(GetDocumentProtectionRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getDocumentProtection");
        }
        

        com.squareup.okhttp.Call call = getDocumentProtectionCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reads document protection common info.
     * 
     * @return ProtectionDataResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProtectionDataResponse getDocumentProtection(GetDocumentProtectionRequest request) throws ApiException {
        try {
            ApiResponse<ProtectionDataResponse> resp = getDocumentProtectionWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ProtectionDataResponse> resp = getDocumentProtectionWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reads document protection common info.
     * 
     * @return ApiResponse&lt;ProtectionDataResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ProtectionDataResponse> getDocumentProtectionWithHttpInfo(GetDocumentProtectionRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDocumentProtectionValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ProtectionDataResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reads document protection common info. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDocumentProtectionAsync(GetDocumentProtectionRequest request, final ApiCallback<ProtectionDataResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDocumentProtectionValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProtectionDataResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDocumentStatistics
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDocumentStatisticsCall(GetDocumentStatisticsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/statistics"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "includeComments", request.getIncludeComments());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "includeFootnotes", request.getIncludeFootnotes());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "includeTextInShapes", request.getIncludeTextInShapes());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDocumentStatisticsValidateBeforeCall(GetDocumentStatisticsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getDocumentStatistics");
        }
        

        com.squareup.okhttp.Call call = getDocumentStatisticsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reads document statistics.
     * 
     * @return StatDataResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StatDataResponse getDocumentStatistics(GetDocumentStatisticsRequest request) throws ApiException {
        try {
            ApiResponse<StatDataResponse> resp = getDocumentStatisticsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<StatDataResponse> resp = getDocumentStatisticsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reads document statistics.
     * 
     * @return ApiResponse&lt;StatDataResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<StatDataResponse> getDocumentStatisticsWithHttpInfo(GetDocumentStatisticsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDocumentStatisticsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<StatDataResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reads document statistics. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDocumentStatisticsAsync(GetDocumentStatisticsRequest request, final ApiCallback<StatDataResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDocumentStatisticsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StatDataResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDocumentWithFormat
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getDocumentWithFormatCall(GetDocumentWithFormatRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "format", request.getFormat());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "outPath", request.getOutPath());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fontsLocation", request.getFontsLocation());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDocumentWithFormatValidateBeforeCall(GetDocumentWithFormatRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getDocumentWithFormat");
        }
        
        // verify the required parameter 'Format' is set
        if (request.getFormat() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Format' when calling getDocumentWithFormat");
        }
        

        com.squareup.okhttp.Call call = getDocumentWithFormatCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Exports the document into the specified format.
     * 
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File getDocumentWithFormat(GetDocumentWithFormatRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = getDocumentWithFormatWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = getDocumentWithFormatWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Exports the document into the specified format.
     * 
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> getDocumentWithFormatWithHttpInfo(GetDocumentWithFormatRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getDocumentWithFormatValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Exports the document into the specified format. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDocumentWithFormatAsync(GetDocumentWithFormatRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDocumentWithFormatValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getField
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getFieldCall(GetFieldRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/fields/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getFieldValidateBeforeCall(GetFieldRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getField");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getField");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getField");
        }
        

        com.squareup.okhttp.Call call = getFieldCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Gets field from document.
     * 
     * @return FieldResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FieldResponse getField(GetFieldRequest request) throws ApiException {
        try {
            ApiResponse<FieldResponse> resp = getFieldWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FieldResponse> resp = getFieldWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Gets field from document.
     * 
     * @return ApiResponse&lt;FieldResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FieldResponse> getFieldWithHttpInfo(GetFieldRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getFieldValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FieldResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets field from document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getFieldAsync(GetFieldRequest request, final ApiCallback<FieldResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getFieldValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FieldResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getFields
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getFieldsCall(GetFieldsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/fields"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getFieldsValidateBeforeCall(GetFieldsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getFields");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getFields");
        }
        

        com.squareup.okhttp.Call call = getFieldsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get fields from document.
     * 
     * @return FieldsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FieldsResponse getFields(GetFieldsRequest request) throws ApiException {
        try {
            ApiResponse<FieldsResponse> resp = getFieldsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FieldsResponse> resp = getFieldsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get fields from document.
     * 
     * @return ApiResponse&lt;FieldsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FieldsResponse> getFieldsWithHttpInfo(GetFieldsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getFieldsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FieldsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get fields from document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getFieldsAsync(GetFieldsRequest request, final ApiCallback<FieldsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getFieldsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FieldsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getFilesList
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getFilesListCall(GetFilesListRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/storage/folder/{path}"
            .replaceAll("\\{" + "path" + "\\}", apiClient.escapeString(request.getPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storageName", request.getStorageName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getFilesListValidateBeforeCall(GetFilesListRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Path' is set
        if (request.getPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Path' when calling getFilesList");
        }
        

        com.squareup.okhttp.Call call = getFilesListCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get all files and folders within a folder
     * 
     * @return FilesList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FilesList getFilesList(GetFilesListRequest request) throws ApiException {
        try {
            ApiResponse<FilesList> resp = getFilesListWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FilesList> resp = getFilesListWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Get all files and folders within a folder
     * 
     * @return ApiResponse&lt;FilesList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FilesList> getFilesListWithHttpInfo(GetFilesListRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getFilesListValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FilesList>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get all files and folders within a folder (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getFilesListAsync(GetFilesListRequest request, final ApiCallback<FilesList> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getFilesListValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FilesList>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getFootnote
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getFootnoteCall(GetFootnoteRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/footnotes/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getFootnoteValidateBeforeCall(GetFootnoteRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getFootnote");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getFootnote");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getFootnote");
        }
        

        com.squareup.okhttp.Call call = getFootnoteCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reads footnote by index.
     * 
     * @return FootnoteResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FootnoteResponse getFootnote(GetFootnoteRequest request) throws ApiException {
        try {
            ApiResponse<FootnoteResponse> resp = getFootnoteWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FootnoteResponse> resp = getFootnoteWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reads footnote by index.
     * 
     * @return ApiResponse&lt;FootnoteResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FootnoteResponse> getFootnoteWithHttpInfo(GetFootnoteRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getFootnoteValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FootnoteResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reads footnote by index. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getFootnoteAsync(GetFootnoteRequest request, final ApiCallback<FootnoteResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getFootnoteValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FootnoteResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getFootnotes
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getFootnotesCall(GetFootnotesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/footnotes"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getFootnotesValidateBeforeCall(GetFootnotesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getFootnotes");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getFootnotes");
        }
        

        com.squareup.okhttp.Call call = getFootnotesCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Gets footnotes from document.
     * 
     * @return FootnotesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FootnotesResponse getFootnotes(GetFootnotesRequest request) throws ApiException {
        try {
            ApiResponse<FootnotesResponse> resp = getFootnotesWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FootnotesResponse> resp = getFootnotesWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Gets footnotes from document.
     * 
     * @return ApiResponse&lt;FootnotesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FootnotesResponse> getFootnotesWithHttpInfo(GetFootnotesRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getFootnotesValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FootnotesResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets footnotes from document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getFootnotesAsync(GetFootnotesRequest request, final ApiCallback<FootnotesResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getFootnotesValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FootnotesResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getFormField
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getFormFieldCall(GetFormFieldRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/formfields/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getFormFieldValidateBeforeCall(GetFormFieldRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getFormField");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getFormField");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getFormField");
        }
        

        com.squareup.okhttp.Call call = getFormFieldCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns representation of an one of the form field.
     * 
     * @return FormFieldResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FormFieldResponse getFormField(GetFormFieldRequest request) throws ApiException {
        try {
            ApiResponse<FormFieldResponse> resp = getFormFieldWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FormFieldResponse> resp = getFormFieldWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns representation of an one of the form field.
     * 
     * @return ApiResponse&lt;FormFieldResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FormFieldResponse> getFormFieldWithHttpInfo(GetFormFieldRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getFormFieldValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FormFieldResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns representation of an one of the form field. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getFormFieldAsync(GetFormFieldRequest request, final ApiCallback<FormFieldResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getFormFieldValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FormFieldResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getFormFields
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getFormFieldsCall(GetFormFieldsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/formfields"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getFormFieldsValidateBeforeCall(GetFormFieldsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getFormFields");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getFormFields");
        }
        

        com.squareup.okhttp.Call call = getFormFieldsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Gets form fields from document.
     * 
     * @return FormFieldsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FormFieldsResponse getFormFields(GetFormFieldsRequest request) throws ApiException {
        try {
            ApiResponse<FormFieldsResponse> resp = getFormFieldsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FormFieldsResponse> resp = getFormFieldsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Gets form fields from document.
     * 
     * @return ApiResponse&lt;FormFieldsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FormFieldsResponse> getFormFieldsWithHttpInfo(GetFormFieldsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getFormFieldsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FormFieldsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets form fields from document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getFormFieldsAsync(GetFormFieldsRequest request, final ApiCallback<FormFieldsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getFormFieldsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FormFieldsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getHeaderFooter
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getHeaderFooterCall(GetHeaderFooterRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/headersfooters/{headerFooterIndex}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "headerFooterIndex" + "\\}", apiClient.escapeString(request.getHeaderFooterIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "filterByType", request.getFilterByType());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getHeaderFooterValidateBeforeCall(GetHeaderFooterRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getHeaderFooter");
        }
        
        // verify the required parameter 'HeaderFooterIndex' is set
        if (request.getHeaderFooterIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'HeaderFooterIndex' when calling getHeaderFooter");
        }
        

        com.squareup.okhttp.Call call = getHeaderFooterCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a header/footer from the document by index.
     * 
     * @return HeaderFooterResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public HeaderFooterResponse getHeaderFooter(GetHeaderFooterRequest request) throws ApiException {
        try {
            ApiResponse<HeaderFooterResponse> resp = getHeaderFooterWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<HeaderFooterResponse> resp = getHeaderFooterWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns a header/footer from the document by index.
     * 
     * @return ApiResponse&lt;HeaderFooterResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<HeaderFooterResponse> getHeaderFooterWithHttpInfo(GetHeaderFooterRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getHeaderFooterValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<HeaderFooterResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a header/footer from the document by index. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getHeaderFooterAsync(GetHeaderFooterRequest request, final ApiCallback<HeaderFooterResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getHeaderFooterValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<HeaderFooterResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getHeaderFooterOfSection
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getHeaderFooterOfSectionCall(GetHeaderFooterOfSectionRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/sections/{sectionIndex}/headersfooters/{headerFooterIndex}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "headerFooterIndex" + "\\}", apiClient.escapeString(request.getHeaderFooterIndex().toString()))
            .replaceAll("\\{" + "sectionIndex" + "\\}", apiClient.escapeString(request.getSectionIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "filterByType", request.getFilterByType());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getHeaderFooterOfSectionValidateBeforeCall(GetHeaderFooterOfSectionRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getHeaderFooterOfSection");
        }
        
        // verify the required parameter 'HeaderFooterIndex' is set
        if (request.getHeaderFooterIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'HeaderFooterIndex' when calling getHeaderFooterOfSection");
        }
        
        // verify the required parameter 'SectionIndex' is set
        if (request.getSectionIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'SectionIndex' when calling getHeaderFooterOfSection");
        }
        

        com.squareup.okhttp.Call call = getHeaderFooterOfSectionCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a header/footer from the document section.
     * 
     * @return HeaderFooterResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public HeaderFooterResponse getHeaderFooterOfSection(GetHeaderFooterOfSectionRequest request) throws ApiException {
        try {
            ApiResponse<HeaderFooterResponse> resp = getHeaderFooterOfSectionWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<HeaderFooterResponse> resp = getHeaderFooterOfSectionWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns a header/footer from the document section.
     * 
     * @return ApiResponse&lt;HeaderFooterResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<HeaderFooterResponse> getHeaderFooterOfSectionWithHttpInfo(GetHeaderFooterOfSectionRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getHeaderFooterOfSectionValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<HeaderFooterResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a header/footer from the document section. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getHeaderFooterOfSectionAsync(GetHeaderFooterOfSectionRequest request, final ApiCallback<HeaderFooterResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getHeaderFooterOfSectionValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<HeaderFooterResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getHeaderFooters
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getHeaderFootersCall(GetHeaderFootersRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{sectionPath}/headersfooters"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "sectionPath" + "\\}", apiClient.escapeString(request.getSectionPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "filterByType", request.getFilterByType());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getHeaderFootersValidateBeforeCall(GetHeaderFootersRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getHeaderFooters");
        }
        
        // verify the required parameter 'SectionPath' is set
        if (request.getSectionPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'SectionPath' when calling getHeaderFooters");
        }
        

        com.squareup.okhttp.Call call = getHeaderFootersCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a list of header/footers from the document.
     * 
     * @return HeaderFootersResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public HeaderFootersResponse getHeaderFooters(GetHeaderFootersRequest request) throws ApiException {
        try {
            ApiResponse<HeaderFootersResponse> resp = getHeaderFootersWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<HeaderFootersResponse> resp = getHeaderFootersWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns a list of header/footers from the document.
     * 
     * @return ApiResponse&lt;HeaderFootersResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<HeaderFootersResponse> getHeaderFootersWithHttpInfo(GetHeaderFootersRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getHeaderFootersValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<HeaderFootersResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a list of header/footers from the document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getHeaderFootersAsync(GetHeaderFootersRequest request, final ApiCallback<HeaderFootersResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getHeaderFootersValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<HeaderFootersResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getOfficeMathObject
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getOfficeMathObjectCall(GetOfficeMathObjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/OfficeMathObjects/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getOfficeMathObjectValidateBeforeCall(GetOfficeMathObjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getOfficeMathObject");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getOfficeMathObject");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getOfficeMathObject");
        }
        

        com.squareup.okhttp.Call call = getOfficeMathObjectCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Reads OfficeMath object by index.
     * 
     * @return OfficeMathObjectResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public OfficeMathObjectResponse getOfficeMathObject(GetOfficeMathObjectRequest request) throws ApiException {
        try {
            ApiResponse<OfficeMathObjectResponse> resp = getOfficeMathObjectWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<OfficeMathObjectResponse> resp = getOfficeMathObjectWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Reads OfficeMath object by index.
     * 
     * @return ApiResponse&lt;OfficeMathObjectResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<OfficeMathObjectResponse> getOfficeMathObjectWithHttpInfo(GetOfficeMathObjectRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getOfficeMathObjectValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<OfficeMathObjectResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Reads OfficeMath object by index. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getOfficeMathObjectAsync(GetOfficeMathObjectRequest request, final ApiCallback<OfficeMathObjectResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getOfficeMathObjectValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<OfficeMathObjectResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getOfficeMathObjects
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getOfficeMathObjectsCall(GetOfficeMathObjectsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/OfficeMathObjects"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getOfficeMathObjectsValidateBeforeCall(GetOfficeMathObjectsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getOfficeMathObjects");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getOfficeMathObjects");
        }
        

        com.squareup.okhttp.Call call = getOfficeMathObjectsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Gets OfficeMath objects from document.
     * 
     * @return OfficeMathObjectsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public OfficeMathObjectsResponse getOfficeMathObjects(GetOfficeMathObjectsRequest request) throws ApiException {
        try {
            ApiResponse<OfficeMathObjectsResponse> resp = getOfficeMathObjectsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<OfficeMathObjectsResponse> resp = getOfficeMathObjectsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Gets OfficeMath objects from document.
     * 
     * @return ApiResponse&lt;OfficeMathObjectsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<OfficeMathObjectsResponse> getOfficeMathObjectsWithHttpInfo(GetOfficeMathObjectsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getOfficeMathObjectsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<OfficeMathObjectsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets OfficeMath objects from document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getOfficeMathObjectsAsync(GetOfficeMathObjectsRequest request, final ApiCallback<OfficeMathObjectsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getOfficeMathObjectsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<OfficeMathObjectsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getParagraph
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getParagraphCall(GetParagraphRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/paragraphs/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getParagraphValidateBeforeCall(GetParagraphRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getParagraph");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getParagraph");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getParagraph");
        }
        

        com.squareup.okhttp.Call call = getParagraphCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * This resource represents one of the paragraphs contained in the document.
     * 
     * @return ParagraphResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ParagraphResponse getParagraph(GetParagraphRequest request) throws ApiException {
        try {
            ApiResponse<ParagraphResponse> resp = getParagraphWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ParagraphResponse> resp = getParagraphWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * This resource represents one of the paragraphs contained in the document.
     * 
     * @return ApiResponse&lt;ParagraphResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ParagraphResponse> getParagraphWithHttpInfo(GetParagraphRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getParagraphValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ParagraphResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * This resource represents one of the paragraphs contained in the document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getParagraphAsync(GetParagraphRequest request, final ApiCallback<ParagraphResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getParagraphValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ParagraphResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getParagraphFormat
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getParagraphFormatCall(GetParagraphFormatRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/paragraphs/{index}/format"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getParagraphFormatValidateBeforeCall(GetParagraphFormatRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getParagraphFormat");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getParagraphFormat");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getParagraphFormat");
        }
        

        com.squareup.okhttp.Call call = getParagraphFormatCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Represents all the formatting for a paragraph.
     * 
     * @return ParagraphFormatResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ParagraphFormatResponse getParagraphFormat(GetParagraphFormatRequest request) throws ApiException {
        try {
            ApiResponse<ParagraphFormatResponse> resp = getParagraphFormatWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ParagraphFormatResponse> resp = getParagraphFormatWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Represents all the formatting for a paragraph.
     * 
     * @return ApiResponse&lt;ParagraphFormatResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ParagraphFormatResponse> getParagraphFormatWithHttpInfo(GetParagraphFormatRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getParagraphFormatValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ParagraphFormatResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Represents all the formatting for a paragraph. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getParagraphFormatAsync(GetParagraphFormatRequest request, final ApiCallback<ParagraphFormatResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getParagraphFormatValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ParagraphFormatResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getParagraphs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getParagraphsCall(GetParagraphsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/paragraphs"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getParagraphsValidateBeforeCall(GetParagraphsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getParagraphs");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getParagraphs");
        }
        

        com.squareup.okhttp.Call call = getParagraphsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a list of paragraphs that are contained in the document.
     * 
     * @return ParagraphLinkCollectionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ParagraphLinkCollectionResponse getParagraphs(GetParagraphsRequest request) throws ApiException {
        try {
            ApiResponse<ParagraphLinkCollectionResponse> resp = getParagraphsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ParagraphLinkCollectionResponse> resp = getParagraphsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns a list of paragraphs that are contained in the document.
     * 
     * @return ApiResponse&lt;ParagraphLinkCollectionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ParagraphLinkCollectionResponse> getParagraphsWithHttpInfo(GetParagraphsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getParagraphsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ParagraphLinkCollectionResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a list of paragraphs that are contained in the document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getParagraphsAsync(GetParagraphsRequest request, final ApiCallback<ParagraphLinkCollectionResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getParagraphsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ParagraphLinkCollectionResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getRun
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getRunCall(GetRunRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{paragraphPath}/runs/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "paragraphPath" + "\\}", apiClient.escapeString(request.getParagraphPath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getRunValidateBeforeCall(GetRunRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getRun");
        }
        
        // verify the required parameter 'ParagraphPath' is set
        if (request.getParagraphPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'ParagraphPath' when calling getRun");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getRun");
        }
        

        com.squareup.okhttp.Call call = getRunCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * This resource represents run of text contained in the document.
     * 
     * @return RunResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public RunResponse getRun(GetRunRequest request) throws ApiException {
        try {
            ApiResponse<RunResponse> resp = getRunWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<RunResponse> resp = getRunWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * This resource represents run of text contained in the document.
     * 
     * @return ApiResponse&lt;RunResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<RunResponse> getRunWithHttpInfo(GetRunRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getRunValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<RunResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * This resource represents run of text contained in the document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getRunAsync(GetRunRequest request, final ApiCallback<RunResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getRunValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<RunResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getRunFont
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getRunFontCall(GetRunFontRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{paragraphPath}/runs/{index}/font"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "paragraphPath" + "\\}", apiClient.escapeString(request.getParagraphPath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getRunFontValidateBeforeCall(GetRunFontRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getRunFont");
        }
        
        // verify the required parameter 'ParagraphPath' is set
        if (request.getParagraphPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'ParagraphPath' when calling getRunFont");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getRunFont");
        }
        

        com.squareup.okhttp.Call call = getRunFontCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * This resource represents font of run.
     * 
     * @return FontResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FontResponse getRunFont(GetRunFontRequest request) throws ApiException {
        try {
            ApiResponse<FontResponse> resp = getRunFontWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FontResponse> resp = getRunFontWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * This resource represents font of run.
     * 
     * @return ApiResponse&lt;FontResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FontResponse> getRunFontWithHttpInfo(GetRunFontRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getRunFontValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FontResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * This resource represents font of run. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getRunFontAsync(GetRunFontRequest request, final ApiCallback<FontResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getRunFontValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FontResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getRuns
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getRunsCall(GetRunsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{paragraphPath}/runs"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "paragraphPath" + "\\}", apiClient.escapeString(request.getParagraphPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getRunsValidateBeforeCall(GetRunsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getRuns");
        }
        
        // verify the required parameter 'ParagraphPath' is set
        if (request.getParagraphPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'ParagraphPath' when calling getRuns");
        }
        

        com.squareup.okhttp.Call call = getRunsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * This resource represents collection of runs in the paragraph.
     * 
     * @return RunsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public RunsResponse getRuns(GetRunsRequest request) throws ApiException {
        try {
            ApiResponse<RunsResponse> resp = getRunsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<RunsResponse> resp = getRunsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * This resource represents collection of runs in the paragraph.
     * 
     * @return ApiResponse&lt;RunsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<RunsResponse> getRunsWithHttpInfo(GetRunsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getRunsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<RunsResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * This resource represents collection of runs in the paragraph. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getRunsAsync(GetRunsRequest request, final ApiCallback<RunsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getRunsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<RunsResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getSection
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getSectionCall(GetSectionRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/sections/{sectionIndex}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "sectionIndex" + "\\}", apiClient.escapeString(request.getSectionIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getSectionValidateBeforeCall(GetSectionRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getSection");
        }
        
        // verify the required parameter 'SectionIndex' is set
        if (request.getSectionIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'SectionIndex' when calling getSection");
        }
        

        com.squareup.okhttp.Call call = getSectionCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Gets document section by index.
     * 
     * @return SectionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SectionResponse getSection(GetSectionRequest request) throws ApiException {
        try {
            ApiResponse<SectionResponse> resp = getSectionWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<SectionResponse> resp = getSectionWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Gets document section by index.
     * 
     * @return ApiResponse&lt;SectionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<SectionResponse> getSectionWithHttpInfo(GetSectionRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getSectionValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<SectionResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets document section by index. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getSectionAsync(GetSectionRequest request, final ApiCallback<SectionResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getSectionValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SectionResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getSectionPageSetup
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getSectionPageSetupCall(GetSectionPageSetupRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/sections/{sectionIndex}/pageSetup"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "sectionIndex" + "\\}", apiClient.escapeString(request.getSectionIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getSectionPageSetupValidateBeforeCall(GetSectionPageSetupRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getSectionPageSetup");
        }
        
        // verify the required parameter 'SectionIndex' is set
        if (request.getSectionIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'SectionIndex' when calling getSectionPageSetup");
        }
        

        com.squareup.okhttp.Call call = getSectionPageSetupCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Gets page setup of section.
     * 
     * @return SectionPageSetupResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SectionPageSetupResponse getSectionPageSetup(GetSectionPageSetupRequest request) throws ApiException {
        try {
            ApiResponse<SectionPageSetupResponse> resp = getSectionPageSetupWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<SectionPageSetupResponse> resp = getSectionPageSetupWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Gets page setup of section.
     * 
     * @return ApiResponse&lt;SectionPageSetupResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<SectionPageSetupResponse> getSectionPageSetupWithHttpInfo(GetSectionPageSetupRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getSectionPageSetupValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<SectionPageSetupResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets page setup of section. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getSectionPageSetupAsync(GetSectionPageSetupRequest request, final ApiCallback<SectionPageSetupResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getSectionPageSetupValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SectionPageSetupResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getSections
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getSectionsCall(GetSectionsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/sections"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getSectionsValidateBeforeCall(GetSectionsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getSections");
        }
        

        com.squareup.okhttp.Call call = getSectionsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a list of sections that are contained in the document.
     * 
     * @return SectionLinkCollectionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SectionLinkCollectionResponse getSections(GetSectionsRequest request) throws ApiException {
        try {
            ApiResponse<SectionLinkCollectionResponse> resp = getSectionsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<SectionLinkCollectionResponse> resp = getSectionsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns a list of sections that are contained in the document.
     * 
     * @return ApiResponse&lt;SectionLinkCollectionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<SectionLinkCollectionResponse> getSectionsWithHttpInfo(GetSectionsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getSectionsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<SectionLinkCollectionResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a list of sections that are contained in the document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getSectionsAsync(GetSectionsRequest request, final ApiCallback<SectionLinkCollectionResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getSectionsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SectionLinkCollectionResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTable
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getTableCall(GetTableRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/tables/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTableValidateBeforeCall(GetTableRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getTable");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getTable");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getTable");
        }
        

        com.squareup.okhttp.Call call = getTableCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a table.
     * 
     * @return TableResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TableResponse getTable(GetTableRequest request) throws ApiException {
        try {
            ApiResponse<TableResponse> resp = getTableWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TableResponse> resp = getTableWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns a table.
     * 
     * @return ApiResponse&lt;TableResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TableResponse> getTableWithHttpInfo(GetTableRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getTableValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TableResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a table. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTableAsync(GetTableRequest request, final ApiCallback<TableResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTableValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TableResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTableCell
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getTableCellCall(GetTableCellRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{tableRowPath}/cells/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "tableRowPath" + "\\}", apiClient.escapeString(request.getTableRowPath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTableCellValidateBeforeCall(GetTableCellRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getTableCell");
        }
        
        // verify the required parameter 'TableRowPath' is set
        if (request.getTableRowPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'TableRowPath' when calling getTableCell");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getTableCell");
        }
        

        com.squareup.okhttp.Call call = getTableCellCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a table cell.
     * 
     * @return TableCellResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TableCellResponse getTableCell(GetTableCellRequest request) throws ApiException {
        try {
            ApiResponse<TableCellResponse> resp = getTableCellWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TableCellResponse> resp = getTableCellWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns a table cell.
     * 
     * @return ApiResponse&lt;TableCellResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TableCellResponse> getTableCellWithHttpInfo(GetTableCellRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getTableCellValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TableCellResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a table cell. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTableCellAsync(GetTableCellRequest request, final ApiCallback<TableCellResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTableCellValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TableCellResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTableCellFormat
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getTableCellFormatCall(GetTableCellFormatRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{tableRowPath}/cells/{index}/cellformat"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "tableRowPath" + "\\}", apiClient.escapeString(request.getTableRowPath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTableCellFormatValidateBeforeCall(GetTableCellFormatRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getTableCellFormat");
        }
        
        // verify the required parameter 'TableRowPath' is set
        if (request.getTableRowPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'TableRowPath' when calling getTableCellFormat");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getTableCellFormat");
        }
        

        com.squareup.okhttp.Call call = getTableCellFormatCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a table cell format.
     * 
     * @return TableCellFormatResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TableCellFormatResponse getTableCellFormat(GetTableCellFormatRequest request) throws ApiException {
        try {
            ApiResponse<TableCellFormatResponse> resp = getTableCellFormatWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TableCellFormatResponse> resp = getTableCellFormatWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns a table cell format.
     * 
     * @return ApiResponse&lt;TableCellFormatResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TableCellFormatResponse> getTableCellFormatWithHttpInfo(GetTableCellFormatRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getTableCellFormatValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TableCellFormatResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a table cell format. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTableCellFormatAsync(GetTableCellFormatRequest request, final ApiCallback<TableCellFormatResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTableCellFormatValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TableCellFormatResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTableProperties
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getTablePropertiesCall(GetTablePropertiesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/tables/{index}/properties"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTablePropertiesValidateBeforeCall(GetTablePropertiesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getTableProperties");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getTableProperties");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getTableProperties");
        }
        

        com.squareup.okhttp.Call call = getTablePropertiesCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a table properties.
     * 
     * @return TablePropertiesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TablePropertiesResponse getTableProperties(GetTablePropertiesRequest request) throws ApiException {
        try {
            ApiResponse<TablePropertiesResponse> resp = getTablePropertiesWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TablePropertiesResponse> resp = getTablePropertiesWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns a table properties.
     * 
     * @return ApiResponse&lt;TablePropertiesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TablePropertiesResponse> getTablePropertiesWithHttpInfo(GetTablePropertiesRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getTablePropertiesValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TablePropertiesResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a table properties. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTablePropertiesAsync(GetTablePropertiesRequest request, final ApiCallback<TablePropertiesResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTablePropertiesValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TablePropertiesResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTableRow
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getTableRowCall(GetTableRowRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{tablePath}/rows/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "tablePath" + "\\}", apiClient.escapeString(request.getTablePath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTableRowValidateBeforeCall(GetTableRowRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getTableRow");
        }
        
        // verify the required parameter 'TablePath' is set
        if (request.getTablePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'TablePath' when calling getTableRow");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getTableRow");
        }
        

        com.squareup.okhttp.Call call = getTableRowCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a table row.
     * 
     * @return TableRowResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TableRowResponse getTableRow(GetTableRowRequest request) throws ApiException {
        try {
            ApiResponse<TableRowResponse> resp = getTableRowWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TableRowResponse> resp = getTableRowWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns a table row.
     * 
     * @return ApiResponse&lt;TableRowResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TableRowResponse> getTableRowWithHttpInfo(GetTableRowRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getTableRowValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TableRowResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a table row. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTableRowAsync(GetTableRowRequest request, final ApiCallback<TableRowResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTableRowValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TableRowResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTableRowFormat
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getTableRowFormatCall(GetTableRowFormatRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{tablePath}/rows/{index}/rowformat"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "tablePath" + "\\}", apiClient.escapeString(request.getTablePath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTableRowFormatValidateBeforeCall(GetTableRowFormatRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getTableRowFormat");
        }
        
        // verify the required parameter 'TablePath' is set
        if (request.getTablePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'TablePath' when calling getTableRowFormat");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling getTableRowFormat");
        }
        

        com.squareup.okhttp.Call call = getTableRowFormatCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a table row format.
     * 
     * @return TableRowFormatResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TableRowFormatResponse getTableRowFormat(GetTableRowFormatRequest request) throws ApiException {
        try {
            ApiResponse<TableRowFormatResponse> resp = getTableRowFormatWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TableRowFormatResponse> resp = getTableRowFormatWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns a table row format.
     * 
     * @return ApiResponse&lt;TableRowFormatResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TableRowFormatResponse> getTableRowFormatWithHttpInfo(GetTableRowFormatRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getTableRowFormatValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TableRowFormatResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a table row format. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTableRowFormatAsync(GetTableRowFormatRequest request, final ApiCallback<TableRowFormatResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTableRowFormatValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TableRowFormatResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTables
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call getTablesCall(GetTablesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/tables"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTablesValidateBeforeCall(GetTablesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling getTables");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling getTables");
        }
        

        com.squareup.okhttp.Call call = getTablesCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a list of tables that are contained in the document.
     * 
     * @return TableLinkCollectionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TableLinkCollectionResponse getTables(GetTablesRequest request) throws ApiException {
        try {
            ApiResponse<TableLinkCollectionResponse> resp = getTablesWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TableLinkCollectionResponse> resp = getTablesWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Returns a list of tables that are contained in the document.
     * 
     * @return ApiResponse&lt;TableLinkCollectionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TableLinkCollectionResponse> getTablesWithHttpInfo(GetTablesRequest request) throws ApiException {
        com.squareup.okhttp.Call call = getTablesValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TableLinkCollectionResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a list of tables that are contained in the document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTablesAsync(GetTablesRequest request, final ApiCallback<TableLinkCollectionResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTablesValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TableLinkCollectionResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for insertComment
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call insertCommentCall(InsertCommentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getComment();

        // create path and map variables
        String localVarPath = "/words/{name}/comments"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call insertCommentValidateBeforeCall(InsertCommentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling insertComment");
        }
        
        // verify the required parameter 'Comment' is set
        if (request.getComment() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Comment' when calling insertComment");
        }
        

        com.squareup.okhttp.Call call = insertCommentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds comment to document, returns inserted comment data.
     * 
     * @return CommentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CommentResponse insertComment(InsertCommentRequest request) throws ApiException {
        try {
            ApiResponse<CommentResponse> resp = insertCommentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<CommentResponse> resp = insertCommentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Adds comment to document, returns inserted comment data.
     * 
     * @return ApiResponse&lt;CommentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<CommentResponse> insertCommentWithHttpInfo(InsertCommentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = insertCommentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<CommentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Adds comment to document, returns inserted comment data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call insertCommentAsync(InsertCommentRequest request, final ApiCallback<CommentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = insertCommentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CommentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for insertDrawingObject
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call insertDrawingObjectCall(InsertDrawingObjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/drawingObjects"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        if (request.getDrawingObject() != null)
          localVarFormParams.put("DrawingObject", request.getDrawingObject());
if (request.getImageFile() != null)
          localVarFormParams.put("ImageFile", request.getImageFile());

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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call insertDrawingObjectValidateBeforeCall(InsertDrawingObjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling insertDrawingObject");
        }
        
        // verify the required parameter 'DrawingObject' is set
        if (request.getDrawingObject() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'DrawingObject' when calling insertDrawingObject");
        }
        
        // verify the required parameter 'ImageFile' is set
        if (request.getImageFile() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'ImageFile' when calling insertDrawingObject");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling insertDrawingObject");
        }
        

        com.squareup.okhttp.Call call = insertDrawingObjectCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds drawing object to document, returns added  drawing object&#39;s data.
     * 
     * @return DrawingObjectResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DrawingObjectResponse insertDrawingObject(InsertDrawingObjectRequest request) throws ApiException {
        try {
            ApiResponse<DrawingObjectResponse> resp = insertDrawingObjectWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DrawingObjectResponse> resp = insertDrawingObjectWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Adds drawing object to document, returns added  drawing object&#39;s data.
     * 
     * @return ApiResponse&lt;DrawingObjectResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DrawingObjectResponse> insertDrawingObjectWithHttpInfo(InsertDrawingObjectRequest request) throws ApiException {
        com.squareup.okhttp.Call call = insertDrawingObjectValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DrawingObjectResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Adds drawing object to document, returns added  drawing object&#39;s data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call insertDrawingObjectAsync(InsertDrawingObjectRequest request, final ApiCallback<DrawingObjectResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = insertDrawingObjectValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DrawingObjectResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for insertField
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call insertFieldCall(InsertFieldRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getField();

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/fields"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "insertBeforeNode", request.getInsertBeforeNode());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call insertFieldValidateBeforeCall(InsertFieldRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling insertField");
        }
        
        // verify the required parameter 'Field' is set
        if (request.getField() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Field' when calling insertField");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling insertField");
        }
        

        com.squareup.okhttp.Call call = insertFieldCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds field to document, returns inserted field&#39;s data.
     * 
     * @return FieldResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FieldResponse insertField(InsertFieldRequest request) throws ApiException {
        try {
            ApiResponse<FieldResponse> resp = insertFieldWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FieldResponse> resp = insertFieldWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Adds field to document, returns inserted field&#39;s data.
     * 
     * @return ApiResponse&lt;FieldResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FieldResponse> insertFieldWithHttpInfo(InsertFieldRequest request) throws ApiException {
        com.squareup.okhttp.Call call = insertFieldValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FieldResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Adds field to document, returns inserted field&#39;s data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call insertFieldAsync(InsertFieldRequest request, final ApiCallback<FieldResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = insertFieldValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FieldResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for insertFootnote
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call insertFootnoteCall(InsertFootnoteRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getFootnoteDto();

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/footnotes"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call insertFootnoteValidateBeforeCall(InsertFootnoteRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling insertFootnote");
        }
        
        // verify the required parameter 'FootnoteDto' is set
        if (request.getFootnoteDto() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'FootnoteDto' when calling insertFootnote");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling insertFootnote");
        }
        

        com.squareup.okhttp.Call call = insertFootnoteCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds footnote to document, returns added footnote&#39;s data.
     * 
     * @return FootnoteResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FootnoteResponse insertFootnote(InsertFootnoteRequest request) throws ApiException {
        try {
            ApiResponse<FootnoteResponse> resp = insertFootnoteWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FootnoteResponse> resp = insertFootnoteWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Adds footnote to document, returns added footnote&#39;s data.
     * 
     * @return ApiResponse&lt;FootnoteResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FootnoteResponse> insertFootnoteWithHttpInfo(InsertFootnoteRequest request) throws ApiException {
        com.squareup.okhttp.Call call = insertFootnoteValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FootnoteResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Adds footnote to document, returns added footnote&#39;s data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call insertFootnoteAsync(InsertFootnoteRequest request, final ApiCallback<FootnoteResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = insertFootnoteValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FootnoteResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for insertFormField
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call insertFormFieldCall(InsertFormFieldRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getFormField();

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/formfields"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "insertBeforeNode", request.getInsertBeforeNode());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call insertFormFieldValidateBeforeCall(InsertFormFieldRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling insertFormField");
        }
        
        // verify the required parameter 'FormField' is set
        if (request.getFormField() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'FormField' when calling insertFormField");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling insertFormField");
        }
        

        com.squareup.okhttp.Call call = insertFormFieldCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds form field to paragraph, returns added form field&#39;s data.
     * 
     * @return FormFieldResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FormFieldResponse insertFormField(InsertFormFieldRequest request) throws ApiException {
        try {
            ApiResponse<FormFieldResponse> resp = insertFormFieldWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FormFieldResponse> resp = insertFormFieldWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Adds form field to paragraph, returns added form field&#39;s data.
     * 
     * @return ApiResponse&lt;FormFieldResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FormFieldResponse> insertFormFieldWithHttpInfo(InsertFormFieldRequest request) throws ApiException {
        com.squareup.okhttp.Call call = insertFormFieldValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FormFieldResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Adds form field to paragraph, returns added form field&#39;s data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call insertFormFieldAsync(InsertFormFieldRequest request, final ApiCallback<FormFieldResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = insertFormFieldValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FormFieldResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for insertHeaderFooter
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call insertHeaderFooterCall(InsertHeaderFooterRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getHeaderFooterType();

        // create path and map variables
        String localVarPath = "/words/{name}/{sectionPath}/headersfooters"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "sectionPath" + "\\}", apiClient.escapeString(request.getSectionPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call insertHeaderFooterValidateBeforeCall(InsertHeaderFooterRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling insertHeaderFooter");
        }
        
        // verify the required parameter 'HeaderFooterType' is set
        if (request.getHeaderFooterType() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'HeaderFooterType' when calling insertHeaderFooter");
        }
        
        // verify the required parameter 'SectionPath' is set
        if (request.getSectionPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'SectionPath' when calling insertHeaderFooter");
        }
        

        com.squareup.okhttp.Call call = insertHeaderFooterCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Inserts to document header or footer.
     * 
     * @return HeaderFooterResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public HeaderFooterResponse insertHeaderFooter(InsertHeaderFooterRequest request) throws ApiException {
        try {
            ApiResponse<HeaderFooterResponse> resp = insertHeaderFooterWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<HeaderFooterResponse> resp = insertHeaderFooterWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Inserts to document header or footer.
     * 
     * @return ApiResponse&lt;HeaderFooterResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<HeaderFooterResponse> insertHeaderFooterWithHttpInfo(InsertHeaderFooterRequest request) throws ApiException {
        com.squareup.okhttp.Call call = insertHeaderFooterValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<HeaderFooterResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Inserts to document header or footer. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call insertHeaderFooterAsync(InsertHeaderFooterRequest request, final ApiCallback<HeaderFooterResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = insertHeaderFooterValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<HeaderFooterResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for insertPageNumbers
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call insertPageNumbersCall(InsertPageNumbersRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getPageNumber();

        // create path and map variables
        String localVarPath = "/words/{name}/insertPageNumbers"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call insertPageNumbersValidateBeforeCall(InsertPageNumbersRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling insertPageNumbers");
        }
        
        // verify the required parameter 'PageNumber' is set
        if (request.getPageNumber() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'PageNumber' when calling insertPageNumbers");
        }
        

        com.squareup.okhttp.Call call = insertPageNumbersCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Inserts document page numbers.
     * 
     * @return DocumentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentResponse insertPageNumbers(InsertPageNumbersRequest request) throws ApiException {
        try {
            ApiResponse<DocumentResponse> resp = insertPageNumbersWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentResponse> resp = insertPageNumbersWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Inserts document page numbers.
     * 
     * @return ApiResponse&lt;DocumentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentResponse> insertPageNumbersWithHttpInfo(InsertPageNumbersRequest request) throws ApiException {
        com.squareup.okhttp.Call call = insertPageNumbersValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Inserts document page numbers. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call insertPageNumbersAsync(InsertPageNumbersRequest request, final ApiCallback<DocumentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = insertPageNumbersValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for insertParagraph
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call insertParagraphCall(InsertParagraphRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getParagraph();

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/paragraphs"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "insertBeforeNode", request.getInsertBeforeNode());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call insertParagraphValidateBeforeCall(InsertParagraphRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling insertParagraph");
        }
        
        // verify the required parameter 'Paragraph' is set
        if (request.getParagraph() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Paragraph' when calling insertParagraph");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling insertParagraph");
        }
        

        com.squareup.okhttp.Call call = insertParagraphCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds paragraph to document, returns added paragraph&#39;s data.
     * 
     * @return ParagraphResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ParagraphResponse insertParagraph(InsertParagraphRequest request) throws ApiException {
        try {
            ApiResponse<ParagraphResponse> resp = insertParagraphWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ParagraphResponse> resp = insertParagraphWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Adds paragraph to document, returns added paragraph&#39;s data.
     * 
     * @return ApiResponse&lt;ParagraphResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ParagraphResponse> insertParagraphWithHttpInfo(InsertParagraphRequest request) throws ApiException {
        com.squareup.okhttp.Call call = insertParagraphValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ParagraphResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Adds paragraph to document, returns added paragraph&#39;s data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call insertParagraphAsync(InsertParagraphRequest request, final ApiCallback<ParagraphResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = insertParagraphValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ParagraphResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for insertRun
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call insertRunCall(InsertRunRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getRun();

        // create path and map variables
        String localVarPath = "/words/{name}/{paragraphPath}/runs"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "paragraphPath" + "\\}", apiClient.escapeString(request.getParagraphPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "insertBeforeNode", request.getInsertBeforeNode());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call insertRunValidateBeforeCall(InsertRunRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling insertRun");
        }
        
        // verify the required parameter 'ParagraphPath' is set
        if (request.getParagraphPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'ParagraphPath' when calling insertRun");
        }
        
        // verify the required parameter 'Run' is set
        if (request.getRun() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Run' when calling insertRun");
        }
        

        com.squareup.okhttp.Call call = insertRunCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds run to document, returns added paragraph&#39;s data.
     * 
     * @return RunResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public RunResponse insertRun(InsertRunRequest request) throws ApiException {
        try {
            ApiResponse<RunResponse> resp = insertRunWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<RunResponse> resp = insertRunWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Adds run to document, returns added paragraph&#39;s data.
     * 
     * @return ApiResponse&lt;RunResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<RunResponse> insertRunWithHttpInfo(InsertRunRequest request) throws ApiException {
        com.squareup.okhttp.Call call = insertRunValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<RunResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Adds run to document, returns added paragraph&#39;s data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call insertRunAsync(InsertRunRequest request, final ApiCallback<RunResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = insertRunValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<RunResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for insertTable
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call insertTableCall(InsertTableRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getTable();

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/tables"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call insertTableValidateBeforeCall(InsertTableRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling insertTable");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling insertTable");
        }
        

        com.squareup.okhttp.Call call = insertTableCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds table to document, returns added table&#39;s data.             
     * 
     * @return TableResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TableResponse insertTable(InsertTableRequest request) throws ApiException {
        try {
            ApiResponse<TableResponse> resp = insertTableWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TableResponse> resp = insertTableWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Adds table to document, returns added table&#39;s data.             
     * 
     * @return ApiResponse&lt;TableResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TableResponse> insertTableWithHttpInfo(InsertTableRequest request) throws ApiException {
        com.squareup.okhttp.Call call = insertTableValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TableResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Adds table to document, returns added table&#39;s data.              (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call insertTableAsync(InsertTableRequest request, final ApiCallback<TableResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = insertTableValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TableResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for insertTableCell
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call insertTableCellCall(InsertTableCellRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getCell();

        // create path and map variables
        String localVarPath = "/words/{name}/{tableRowPath}/cells"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "tableRowPath" + "\\}", apiClient.escapeString(request.getTableRowPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call insertTableCellValidateBeforeCall(InsertTableCellRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling insertTableCell");
        }
        
        // verify the required parameter 'TableRowPath' is set
        if (request.getTableRowPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'TableRowPath' when calling insertTableCell");
        }
        

        com.squareup.okhttp.Call call = insertTableCellCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds table cell to table, returns added cell&#39;s data.             
     * 
     * @return TableCellResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TableCellResponse insertTableCell(InsertTableCellRequest request) throws ApiException {
        try {
            ApiResponse<TableCellResponse> resp = insertTableCellWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TableCellResponse> resp = insertTableCellWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Adds table cell to table, returns added cell&#39;s data.             
     * 
     * @return ApiResponse&lt;TableCellResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TableCellResponse> insertTableCellWithHttpInfo(InsertTableCellRequest request) throws ApiException {
        com.squareup.okhttp.Call call = insertTableCellValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TableCellResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Adds table cell to table, returns added cell&#39;s data.              (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call insertTableCellAsync(InsertTableCellRequest request, final ApiCallback<TableCellResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = insertTableCellValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TableCellResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for insertTableRow
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call insertTableRowCall(InsertTableRowRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getRow();

        // create path and map variables
        String localVarPath = "/words/{name}/{tablePath}/rows"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "tablePath" + "\\}", apiClient.escapeString(request.getTablePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call insertTableRowValidateBeforeCall(InsertTableRowRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling insertTableRow");
        }
        
        // verify the required parameter 'TablePath' is set
        if (request.getTablePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'TablePath' when calling insertTableRow");
        }
        

        com.squareup.okhttp.Call call = insertTableRowCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Adds table row to table, returns added row&#39;s data.             
     * 
     * @return TableRowResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TableRowResponse insertTableRow(InsertTableRowRequest request) throws ApiException {
        try {
            ApiResponse<TableRowResponse> resp = insertTableRowWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TableRowResponse> resp = insertTableRowWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Adds table row to table, returns added row&#39;s data.             
     * 
     * @return ApiResponse&lt;TableRowResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TableRowResponse> insertTableRowWithHttpInfo(InsertTableRowRequest request) throws ApiException {
        com.squareup.okhttp.Call call = insertTableRowValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TableRowResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Adds table row to table, returns added row&#39;s data.              (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call insertTableRowAsync(InsertTableRowRequest request, final ApiCallback<TableRowResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = insertTableRowValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TableRowResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for insertWatermarkImage
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call insertWatermarkImageCall(InsertWatermarkImageRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/watermarks/images"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "rotationAngle", request.getRotationAngle());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "image", request.getImage());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        if (request.getImageFile() != null)
          localVarFormParams.put("ImageFile", request.getImageFile());

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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call insertWatermarkImageValidateBeforeCall(InsertWatermarkImageRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling insertWatermarkImage");
        }
        

        com.squareup.okhttp.Call call = insertWatermarkImageCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Inserts document watermark image.
     * 
     * @return DocumentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentResponse insertWatermarkImage(InsertWatermarkImageRequest request) throws ApiException {
        try {
            ApiResponse<DocumentResponse> resp = insertWatermarkImageWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentResponse> resp = insertWatermarkImageWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Inserts document watermark image.
     * 
     * @return ApiResponse&lt;DocumentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentResponse> insertWatermarkImageWithHttpInfo(InsertWatermarkImageRequest request) throws ApiException {
        com.squareup.okhttp.Call call = insertWatermarkImageValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Inserts document watermark image. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call insertWatermarkImageAsync(InsertWatermarkImageRequest request, final ApiCallback<DocumentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = insertWatermarkImageValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for insertWatermarkText
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call insertWatermarkTextCall(InsertWatermarkTextRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getWatermarkText();

        // create path and map variables
        String localVarPath = "/words/{name}/watermarks/texts"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call insertWatermarkTextValidateBeforeCall(InsertWatermarkTextRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling insertWatermarkText");
        }
        
        // verify the required parameter 'WatermarkText' is set
        if (request.getWatermarkText() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'WatermarkText' when calling insertWatermarkText");
        }
        

        com.squareup.okhttp.Call call = insertWatermarkTextCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Inserts document watermark text.
     * 
     * @return DocumentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentResponse insertWatermarkText(InsertWatermarkTextRequest request) throws ApiException {
        try {
            ApiResponse<DocumentResponse> resp = insertWatermarkTextWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentResponse> resp = insertWatermarkTextWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Inserts document watermark text.
     * 
     * @return ApiResponse&lt;DocumentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentResponse> insertWatermarkTextWithHttpInfo(InsertWatermarkTextRequest request) throws ApiException {
        com.squareup.okhttp.Call call = insertWatermarkTextValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Inserts document watermark text. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call insertWatermarkTextAsync(InsertWatermarkTextRequest request, final ApiCallback<DocumentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = insertWatermarkTextValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for loadWebDocument
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call loadWebDocumentCall(LoadWebDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getData();

        // create path and map variables
        String localVarPath = "/words/loadWebDocument";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call loadWebDocumentValidateBeforeCall(LoadWebDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Data' is set
        if (request.getData() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Data' when calling loadWebDocument");
        }
        

        com.squareup.okhttp.Call call = loadWebDocumentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Loads new document from web into the file with any supported format of data.
     * 
     * @return SaveResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SaveResponse loadWebDocument(LoadWebDocumentRequest request) throws ApiException {
        try {
            ApiResponse<SaveResponse> resp = loadWebDocumentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<SaveResponse> resp = loadWebDocumentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Loads new document from web into the file with any supported format of data.
     * 
     * @return ApiResponse&lt;SaveResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<SaveResponse> loadWebDocumentWithHttpInfo(LoadWebDocumentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = loadWebDocumentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<SaveResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Loads new document from web into the file with any supported format of data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call loadWebDocumentAsync(LoadWebDocumentRequest request, final ApiCallback<SaveResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = loadWebDocumentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SaveResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for moveFile
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call moveFileCall(MoveFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/storage/file/move/{srcPath}"
            .replaceAll("\\{" + "srcPath" + "\\}", apiClient.escapeString(request.getSrcPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destPath", request.getDestPath());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "srcStorageName", request.getSrcStorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destStorageName", request.getDestStorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "versionId", request.getVersionId());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call moveFileValidateBeforeCall(MoveFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'DestPath' is set
        if (request.getDestPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'DestPath' when calling moveFile");
        }
        
        // verify the required parameter 'SrcPath' is set
        if (request.getSrcPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'SrcPath' when calling moveFile");
        }
        

        com.squareup.okhttp.Call call = moveFileCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Move file
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void moveFile(MoveFileRequest request) throws ApiException {
        try {
            moveFileWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                moveFileWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Move file
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> moveFileWithHttpInfo(MoveFileRequest request) throws ApiException {
        com.squareup.okhttp.Call call = moveFileValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Move file (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call moveFileAsync(MoveFileRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = moveFileValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for moveFolder
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call moveFolderCall(MoveFolderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/storage/folder/move/{srcPath}"
            .replaceAll("\\{" + "srcPath" + "\\}", apiClient.escapeString(request.getSrcPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destPath", request.getDestPath());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "srcStorageName", request.getSrcStorageName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destStorageName", request.getDestStorageName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call moveFolderValidateBeforeCall(MoveFolderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'DestPath' is set
        if (request.getDestPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'DestPath' when calling moveFolder");
        }
        
        // verify the required parameter 'SrcPath' is set
        if (request.getSrcPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'SrcPath' when calling moveFolder");
        }
        

        com.squareup.okhttp.Call call = moveFolderCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Move folder
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void moveFolder(MoveFolderRequest request) throws ApiException {
        try {
            moveFolderWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                moveFolderWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Move folder
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> moveFolderWithHttpInfo(MoveFolderRequest request) throws ApiException {
        com.squareup.okhttp.Call call = moveFolderValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Move folder (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call moveFolderAsync(MoveFolderRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = moveFolderValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for protectDocument
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call protectDocumentCall(ProtectDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getProtectionRequest();

        // create path and map variables
        String localVarPath = "/words/{name}/protection"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call protectDocumentValidateBeforeCall(ProtectDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling protectDocument");
        }
        
        // verify the required parameter 'ProtectionRequest' is set
        if (request.getProtectionRequest() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'ProtectionRequest' when calling protectDocument");
        }
        

        com.squareup.okhttp.Call call = protectDocumentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Protects document.
     * 
     * @return ProtectionDataResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProtectionDataResponse protectDocument(ProtectDocumentRequest request) throws ApiException {
        try {
            ApiResponse<ProtectionDataResponse> resp = protectDocumentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ProtectionDataResponse> resp = protectDocumentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Protects document.
     * 
     * @return ApiResponse&lt;ProtectionDataResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ProtectionDataResponse> protectDocumentWithHttpInfo(ProtectDocumentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = protectDocumentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ProtectionDataResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Protects document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call protectDocumentAsync(ProtectDocumentRequest request, final ApiCallback<ProtectionDataResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = protectDocumentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProtectionDataResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for rejectAllRevisions
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call rejectAllRevisionsCall(RejectAllRevisionsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/revisions/rejectAll"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call rejectAllRevisionsValidateBeforeCall(RejectAllRevisionsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling rejectAllRevisions");
        }
        

        com.squareup.okhttp.Call call = rejectAllRevisionsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Rejects all revisions in document
     * 
     * @return RevisionsModificationResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public RevisionsModificationResponse rejectAllRevisions(RejectAllRevisionsRequest request) throws ApiException {
        try {
            ApiResponse<RevisionsModificationResponse> resp = rejectAllRevisionsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<RevisionsModificationResponse> resp = rejectAllRevisionsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Rejects all revisions in document
     * 
     * @return ApiResponse&lt;RevisionsModificationResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<RevisionsModificationResponse> rejectAllRevisionsWithHttpInfo(RejectAllRevisionsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = rejectAllRevisionsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<RevisionsModificationResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Rejects all revisions in document (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call rejectAllRevisionsAsync(RejectAllRevisionsRequest request, final ApiCallback<RevisionsModificationResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = rejectAllRevisionsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<RevisionsModificationResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for renderDrawingObject
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call renderDrawingObjectCall(RenderDrawingObjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/drawingObjects/{index}/render"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "format", request.getFormat());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fontsLocation", request.getFontsLocation());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call renderDrawingObjectValidateBeforeCall(RenderDrawingObjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling renderDrawingObject");
        }
        
        // verify the required parameter 'Format' is set
        if (request.getFormat() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Format' when calling renderDrawingObject");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling renderDrawingObject");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling renderDrawingObject");
        }
        

        com.squareup.okhttp.Call call = renderDrawingObjectCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Renders drawing object to specified format.
     * 
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File renderDrawingObject(RenderDrawingObjectRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = renderDrawingObjectWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = renderDrawingObjectWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Renders drawing object to specified format.
     * 
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> renderDrawingObjectWithHttpInfo(RenderDrawingObjectRequest request) throws ApiException {
        com.squareup.okhttp.Call call = renderDrawingObjectValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Renders drawing object to specified format. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call renderDrawingObjectAsync(RenderDrawingObjectRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = renderDrawingObjectValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for renderMathObject
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call renderMathObjectCall(RenderMathObjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/OfficeMathObjects/{index}/render"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "format", request.getFormat());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fontsLocation", request.getFontsLocation());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call renderMathObjectValidateBeforeCall(RenderMathObjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling renderMathObject");
        }
        
        // verify the required parameter 'Format' is set
        if (request.getFormat() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Format' when calling renderMathObject");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling renderMathObject");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling renderMathObject");
        }
        

        com.squareup.okhttp.Call call = renderMathObjectCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Renders math object to specified format.
     * 
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File renderMathObject(RenderMathObjectRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = renderMathObjectWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = renderMathObjectWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Renders math object to specified format.
     * 
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> renderMathObjectWithHttpInfo(RenderMathObjectRequest request) throws ApiException {
        com.squareup.okhttp.Call call = renderMathObjectValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Renders math object to specified format. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call renderMathObjectAsync(RenderMathObjectRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = renderMathObjectValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for renderPage
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call renderPageCall(RenderPageRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/pages/{pageIndex}/render"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "pageIndex" + "\\}", apiClient.escapeString(request.getPageIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "format", request.getFormat());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fontsLocation", request.getFontsLocation());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call renderPageValidateBeforeCall(RenderPageRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling renderPage");
        }
        
        // verify the required parameter 'PageIndex' is set
        if (request.getPageIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'PageIndex' when calling renderPage");
        }
        
        // verify the required parameter 'Format' is set
        if (request.getFormat() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Format' when calling renderPage");
        }
        

        com.squareup.okhttp.Call call = renderPageCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Renders page to specified format.
     * 
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File renderPage(RenderPageRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = renderPageWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = renderPageWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Renders page to specified format.
     * 
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> renderPageWithHttpInfo(RenderPageRequest request) throws ApiException {
        com.squareup.okhttp.Call call = renderPageValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Renders page to specified format. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call renderPageAsync(RenderPageRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = renderPageValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for renderParagraph
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call renderParagraphCall(RenderParagraphRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/paragraphs/{index}/render"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "format", request.getFormat());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fontsLocation", request.getFontsLocation());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call renderParagraphValidateBeforeCall(RenderParagraphRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling renderParagraph");
        }
        
        // verify the required parameter 'Format' is set
        if (request.getFormat() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Format' when calling renderParagraph");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling renderParagraph");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling renderParagraph");
        }
        

        com.squareup.okhttp.Call call = renderParagraphCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Renders paragraph to specified format.
     * 
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File renderParagraph(RenderParagraphRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = renderParagraphWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = renderParagraphWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Renders paragraph to specified format.
     * 
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> renderParagraphWithHttpInfo(RenderParagraphRequest request) throws ApiException {
        com.squareup.okhttp.Call call = renderParagraphValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Renders paragraph to specified format. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call renderParagraphAsync(RenderParagraphRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = renderParagraphValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for renderTable
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call renderTableCall(RenderTableRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/tables/{index}/render"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "format", request.getFormat());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fontsLocation", request.getFontsLocation());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call renderTableValidateBeforeCall(RenderTableRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling renderTable");
        }
        
        // verify the required parameter 'Format' is set
        if (request.getFormat() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Format' when calling renderTable");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling renderTable");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling renderTable");
        }
        

        com.squareup.okhttp.Call call = renderTableCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Renders table to specified format.
     * 
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File renderTable(RenderTableRequest request) throws ApiException {
        try {
            ApiResponse<File> resp = renderTableWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<File> resp = renderTableWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Renders table to specified format.
     * 
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<File> renderTableWithHttpInfo(RenderTableRequest request) throws ApiException {
        com.squareup.okhttp.Call call = renderTableValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Renders table to specified format. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call renderTableAsync(RenderTableRequest request, final ApiCallback<File> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = renderTableValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for replaceText
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call replaceTextCall(ReplaceTextRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getReplaceText();

        // create path and map variables
        String localVarPath = "/words/{name}/replaceText"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call replaceTextValidateBeforeCall(ReplaceTextRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling replaceText");
        }
        
        // verify the required parameter 'ReplaceText' is set
        if (request.getReplaceText() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'ReplaceText' when calling replaceText");
        }
        

        com.squareup.okhttp.Call call = replaceTextCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Replaces document text.
     * 
     * @return ReplaceTextResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ReplaceTextResponse replaceText(ReplaceTextRequest request) throws ApiException {
        try {
            ApiResponse<ReplaceTextResponse> resp = replaceTextWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ReplaceTextResponse> resp = replaceTextWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Replaces document text.
     * 
     * @return ApiResponse&lt;ReplaceTextResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ReplaceTextResponse> replaceTextWithHttpInfo(ReplaceTextRequest request) throws ApiException {
        com.squareup.okhttp.Call call = replaceTextValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ReplaceTextResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Replaces document text. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call replaceTextAsync(ReplaceTextRequest request, final ApiCallback<ReplaceTextResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = replaceTextValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ReplaceTextResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for resetCache
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call resetCacheCall(ResetCacheRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/fonts/cache";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call resetCacheValidateBeforeCall(ResetCacheRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = resetCacheCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Resets font&#39;s cache.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void resetCache(ResetCacheRequest request) throws ApiException {
        try {
            resetCacheWithHttpInfo(request);
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                resetCacheWithHttpInfo(request);
            }
            throw ex;
        }
    }

    /**
     * Resets font&#39;s cache.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<Void> resetCacheWithHttpInfo(ResetCacheRequest request) throws ApiException {
        com.squareup.okhttp.Call call = resetCacheValidateBeforeCall(request, null, null);
        return apiClient.execute(call);
    }

    /**
     * Resets font&#39;s cache. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call resetCacheAsync(ResetCacheRequest request, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = resetCacheValidateBeforeCall(request, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for saveAs
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call saveAsCall(SaveAsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getSaveOptionsData();

        // create path and map variables
        String localVarPath = "/words/{name}/saveAs"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fontsLocation", request.getFontsLocation());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call saveAsValidateBeforeCall(SaveAsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling saveAs");
        }
        
        // verify the required parameter 'SaveOptionsData' is set
        if (request.getSaveOptionsData() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'SaveOptionsData' when calling saveAs");
        }
        

        com.squareup.okhttp.Call call = saveAsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Converts document to destination format with detailed settings and saves result to storage.
     * 
     * @return SaveResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SaveResponse saveAs(SaveAsRequest request) throws ApiException {
        try {
            ApiResponse<SaveResponse> resp = saveAsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<SaveResponse> resp = saveAsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Converts document to destination format with detailed settings and saves result to storage.
     * 
     * @return ApiResponse&lt;SaveResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<SaveResponse> saveAsWithHttpInfo(SaveAsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = saveAsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<SaveResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Converts document to destination format with detailed settings and saves result to storage. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call saveAsAsync(SaveAsRequest request, final ApiCallback<SaveResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = saveAsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SaveResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for saveAsTiff
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call saveAsTiffCall(SaveAsTiffRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getSaveOptions();

        // create path and map variables
        String localVarPath = "/words/{name}/saveAs/tiff"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "resultFile", request.getResultFile());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "useAntiAliasing", request.getUseAntiAliasing());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "useHighQualityRendering", request.getUseHighQualityRendering());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "imageBrightness", request.getImageBrightness());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "imageColorMode", request.getImageColorMode());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "imageContrast", request.getImageContrast());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "numeralFormat", request.getNumeralFormat());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "pageCount", request.getPageCount());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "pageIndex", request.getPageIndex());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "paperColor", request.getPaperColor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "pixelFormat", request.getPixelFormat());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "resolution", request.getResolution());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "scale", request.getScale());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "tiffCompression", request.getTiffCompression());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "dmlRenderingMode", request.getDmlRenderingMode());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "dmlEffectsRenderingMode", request.getDmlEffectsRenderingMode());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "tiffBinarizationMethod", request.getTiffBinarizationMethod());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "zipOutput", request.getZipOutput());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fontsLocation", request.getFontsLocation());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call saveAsTiffValidateBeforeCall(SaveAsTiffRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling saveAsTiff");
        }
        
        // verify the required parameter 'SaveOptions' is set
        if (request.getSaveOptions() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'SaveOptions' when calling saveAsTiff");
        }
        

        com.squareup.okhttp.Call call = saveAsTiffCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Converts document to tiff with detailed settings and saves result to storage.
     * 
     * @return SaveResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SaveResponse saveAsTiff(SaveAsTiffRequest request) throws ApiException {
        try {
            ApiResponse<SaveResponse> resp = saveAsTiffWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<SaveResponse> resp = saveAsTiffWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Converts document to tiff with detailed settings and saves result to storage.
     * 
     * @return ApiResponse&lt;SaveResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<SaveResponse> saveAsTiffWithHttpInfo(SaveAsTiffRequest request) throws ApiException {
        com.squareup.okhttp.Call call = saveAsTiffValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<SaveResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Converts document to tiff with detailed settings and saves result to storage. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call saveAsTiffAsync(SaveAsTiffRequest request, final ApiCallback<SaveResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = saveAsTiffValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SaveResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for search
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call searchCall(SearchRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/search"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "pattern", request.getPattern());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call searchValidateBeforeCall(SearchRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling search");
        }
        
        // verify the required parameter 'Pattern' is set
        if (request.getPattern() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Pattern' when calling search");
        }
        

        com.squareup.okhttp.Call call = searchCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Searches text in document.
     * 
     * @return SearchResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SearchResponse search(SearchRequest request) throws ApiException {
        try {
            ApiResponse<SearchResponse> resp = searchWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<SearchResponse> resp = searchWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Searches text in document.
     * 
     * @return ApiResponse&lt;SearchResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<SearchResponse> searchWithHttpInfo(SearchRequest request) throws ApiException {
        com.squareup.okhttp.Call call = searchValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<SearchResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Searches text in document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchAsync(SearchRequest request, final ApiCallback<SearchResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = searchValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SearchResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for splitDocument
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call splitDocumentCall(SplitDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/split"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "format", request.getFormat());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "from", request.getFrom());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "to", request.getTo());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "zipOutput", request.getZipOutput());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "fontsLocation", request.getFontsLocation());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call splitDocumentValidateBeforeCall(SplitDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling splitDocument");
        }
        

        com.squareup.okhttp.Call call = splitDocumentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Splits document.
     * 
     * @return SplitDocumentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SplitDocumentResponse splitDocument(SplitDocumentRequest request) throws ApiException {
        try {
            ApiResponse<SplitDocumentResponse> resp = splitDocumentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<SplitDocumentResponse> resp = splitDocumentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Splits document.
     * 
     * @return ApiResponse&lt;SplitDocumentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<SplitDocumentResponse> splitDocumentWithHttpInfo(SplitDocumentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = splitDocumentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<SplitDocumentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Splits document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call splitDocumentAsync(SplitDocumentRequest request, final ApiCallback<SplitDocumentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = splitDocumentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SplitDocumentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for unprotectDocument
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call unprotectDocumentCall(UnprotectDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getProtectionRequest();

        // create path and map variables
        String localVarPath = "/words/{name}/protection"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call unprotectDocumentValidateBeforeCall(UnprotectDocumentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling unprotectDocument");
        }
        
        // verify the required parameter 'ProtectionRequest' is set
        if (request.getProtectionRequest() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'ProtectionRequest' when calling unprotectDocument");
        }
        

        com.squareup.okhttp.Call call = unprotectDocumentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Unprotects document.
     * 
     * @return ProtectionDataResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProtectionDataResponse unprotectDocument(UnprotectDocumentRequest request) throws ApiException {
        try {
            ApiResponse<ProtectionDataResponse> resp = unprotectDocumentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ProtectionDataResponse> resp = unprotectDocumentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Unprotects document.
     * 
     * @return ApiResponse&lt;ProtectionDataResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ProtectionDataResponse> unprotectDocumentWithHttpInfo(UnprotectDocumentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = unprotectDocumentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ProtectionDataResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Unprotects document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call unprotectDocumentAsync(UnprotectDocumentRequest request, final ApiCallback<ProtectionDataResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = unprotectDocumentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProtectionDataResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateBookmark
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateBookmarkCall(UpdateBookmarkRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getBookmarkData();

        // create path and map variables
        String localVarPath = "/words/{name}/bookmarks/{bookmarkName}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "bookmarkName" + "\\}", apiClient.escapeString(request.getBookmarkName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateBookmarkValidateBeforeCall(UpdateBookmarkRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling updateBookmark");
        }
        
        // verify the required parameter 'BookmarkData' is set
        if (request.getBookmarkData() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'BookmarkData' when calling updateBookmark");
        }
        
        // verify the required parameter 'BookmarkName' is set
        if (request.getBookmarkName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'BookmarkName' when calling updateBookmark");
        }
        

        com.squareup.okhttp.Call call = updateBookmarkCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates document bookmark.
     * 
     * @return BookmarkResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public BookmarkResponse updateBookmark(UpdateBookmarkRequest request) throws ApiException {
        try {
            ApiResponse<BookmarkResponse> resp = updateBookmarkWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<BookmarkResponse> resp = updateBookmarkWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates document bookmark.
     * 
     * @return ApiResponse&lt;BookmarkResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<BookmarkResponse> updateBookmarkWithHttpInfo(UpdateBookmarkRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateBookmarkValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<BookmarkResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates document bookmark. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateBookmarkAsync(UpdateBookmarkRequest request, final ApiCallback<BookmarkResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateBookmarkValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<BookmarkResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateBorder
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateBorderCall(UpdateBorderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getBorderProperties();

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/borders/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateBorderValidateBeforeCall(UpdateBorderRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling updateBorder");
        }
        
        // verify the required parameter 'BorderProperties' is set
        if (request.getBorderProperties() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'BorderProperties' when calling updateBorder");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling updateBorder");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling updateBorder");
        }
        

        com.squareup.okhttp.Call call = updateBorderCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates border properties.             
     * &#39;nodePath&#39; should refer to node with cell or row
     * @return BorderResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public BorderResponse updateBorder(UpdateBorderRequest request) throws ApiException {
        try {
            ApiResponse<BorderResponse> resp = updateBorderWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<BorderResponse> resp = updateBorderWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates border properties.             
     * &#39;nodePath&#39; should refer to node with cell or row
     * @return ApiResponse&lt;BorderResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<BorderResponse> updateBorderWithHttpInfo(UpdateBorderRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateBorderValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<BorderResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates border properties.              (asynchronously)
     * &#39;nodePath&#39; should refer to node with cell or row
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateBorderAsync(UpdateBorderRequest request, final ApiCallback<BorderResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateBorderValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<BorderResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateComment
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateCommentCall(UpdateCommentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getComment();

        // create path and map variables
        String localVarPath = "/words/{name}/comments/{commentIndex}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "commentIndex" + "\\}", apiClient.escapeString(request.getCommentIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateCommentValidateBeforeCall(UpdateCommentRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling updateComment");
        }
        
        // verify the required parameter 'CommentIndex' is set
        if (request.getCommentIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'CommentIndex' when calling updateComment");
        }
        
        // verify the required parameter 'Comment' is set
        if (request.getComment() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Comment' when calling updateComment");
        }
        

        com.squareup.okhttp.Call call = updateCommentCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates the comment, returns updated comment data.
     * 
     * @return CommentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CommentResponse updateComment(UpdateCommentRequest request) throws ApiException {
        try {
            ApiResponse<CommentResponse> resp = updateCommentWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<CommentResponse> resp = updateCommentWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates the comment, returns updated comment data.
     * 
     * @return ApiResponse&lt;CommentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<CommentResponse> updateCommentWithHttpInfo(UpdateCommentRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateCommentValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<CommentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates the comment, returns updated comment data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateCommentAsync(UpdateCommentRequest request, final ApiCallback<CommentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateCommentValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CommentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateDrawingObject
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateDrawingObjectCall(UpdateDrawingObjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/drawingObjects/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        if (request.getDrawingObject() != null)
          localVarFormParams.put("DrawingObject", request.getDrawingObject());
if (request.getImageFile() != null)
          localVarFormParams.put("ImageFile", request.getImageFile());

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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateDrawingObjectValidateBeforeCall(UpdateDrawingObjectRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling updateDrawingObject");
        }
        
        // verify the required parameter 'DrawingObject' is set
        if (request.getDrawingObject() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'DrawingObject' when calling updateDrawingObject");
        }
        
        // verify the required parameter 'ImageFile' is set
        if (request.getImageFile() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'ImageFile' when calling updateDrawingObject");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling updateDrawingObject");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling updateDrawingObject");
        }
        

        com.squareup.okhttp.Call call = updateDrawingObjectCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates drawing object, returns updated  drawing object&#39;s data.
     * 
     * @return DrawingObjectResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DrawingObjectResponse updateDrawingObject(UpdateDrawingObjectRequest request) throws ApiException {
        try {
            ApiResponse<DrawingObjectResponse> resp = updateDrawingObjectWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DrawingObjectResponse> resp = updateDrawingObjectWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates drawing object, returns updated  drawing object&#39;s data.
     * 
     * @return ApiResponse&lt;DrawingObjectResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DrawingObjectResponse> updateDrawingObjectWithHttpInfo(UpdateDrawingObjectRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateDrawingObjectValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DrawingObjectResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates drawing object, returns updated  drawing object&#39;s data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateDrawingObjectAsync(UpdateDrawingObjectRequest request, final ApiCallback<DrawingObjectResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateDrawingObjectValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DrawingObjectResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateField
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateFieldCall(UpdateFieldRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getField();

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/fields/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateFieldValidateBeforeCall(UpdateFieldRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling updateField");
        }
        
        // verify the required parameter 'Field' is set
        if (request.getField() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Field' when calling updateField");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling updateField");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling updateField");
        }
        

        com.squareup.okhttp.Call call = updateFieldCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates field&#39;s properties, returns updated field&#39;s data.
     * 
     * @return FieldResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FieldResponse updateField(UpdateFieldRequest request) throws ApiException {
        try {
            ApiResponse<FieldResponse> resp = updateFieldWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FieldResponse> resp = updateFieldWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates field&#39;s properties, returns updated field&#39;s data.
     * 
     * @return ApiResponse&lt;FieldResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FieldResponse> updateFieldWithHttpInfo(UpdateFieldRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateFieldValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FieldResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates field&#39;s properties, returns updated field&#39;s data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateFieldAsync(UpdateFieldRequest request, final ApiCallback<FieldResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateFieldValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FieldResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateFields
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateFieldsCall(UpdateFieldsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/{name}/updateFields"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateFieldsValidateBeforeCall(UpdateFieldsRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling updateFields");
        }
        

        com.squareup.okhttp.Call call = updateFieldsCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates (reevaluate) fields in document.
     * 
     * @return DocumentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentResponse updateFields(UpdateFieldsRequest request) throws ApiException {
        try {
            ApiResponse<DocumentResponse> resp = updateFieldsWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<DocumentResponse> resp = updateFieldsWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates (reevaluate) fields in document.
     * 
     * @return ApiResponse&lt;DocumentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<DocumentResponse> updateFieldsWithHttpInfo(UpdateFieldsRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateFieldsValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates (reevaluate) fields in document. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateFieldsAsync(UpdateFieldsRequest request, final ApiCallback<DocumentResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateFieldsValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateFootnote
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateFootnoteCall(UpdateFootnoteRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getFootnoteDto();

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/footnotes/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateFootnoteValidateBeforeCall(UpdateFootnoteRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling updateFootnote");
        }
        
        // verify the required parameter 'FootnoteDto' is set
        if (request.getFootnoteDto() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'FootnoteDto' when calling updateFootnote");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling updateFootnote");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling updateFootnote");
        }
        

        com.squareup.okhttp.Call call = updateFootnoteCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates footnote&#39;s properties, returns updated run&#39;s data.
     * 
     * @return FootnoteResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FootnoteResponse updateFootnote(UpdateFootnoteRequest request) throws ApiException {
        try {
            ApiResponse<FootnoteResponse> resp = updateFootnoteWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FootnoteResponse> resp = updateFootnoteWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates footnote&#39;s properties, returns updated run&#39;s data.
     * 
     * @return ApiResponse&lt;FootnoteResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FootnoteResponse> updateFootnoteWithHttpInfo(UpdateFootnoteRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateFootnoteValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FootnoteResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates footnote&#39;s properties, returns updated run&#39;s data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateFootnoteAsync(UpdateFootnoteRequest request, final ApiCallback<FootnoteResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateFootnoteValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FootnoteResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateFormField
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateFormFieldCall(UpdateFormFieldRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getFormField();

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/formfields/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateFormFieldValidateBeforeCall(UpdateFormFieldRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling updateFormField");
        }
        
        // verify the required parameter 'FormField' is set
        if (request.getFormField() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'FormField' when calling updateFormField");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling updateFormField");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling updateFormField");
        }
        

        com.squareup.okhttp.Call call = updateFormFieldCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates properties of form field, returns updated form field.
     * 
     * @return FormFieldResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FormFieldResponse updateFormField(UpdateFormFieldRequest request) throws ApiException {
        try {
            ApiResponse<FormFieldResponse> resp = updateFormFieldWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FormFieldResponse> resp = updateFormFieldWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates properties of form field, returns updated form field.
     * 
     * @return ApiResponse&lt;FormFieldResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FormFieldResponse> updateFormFieldWithHttpInfo(UpdateFormFieldRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateFormFieldValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FormFieldResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates properties of form field, returns updated form field. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateFormFieldAsync(UpdateFormFieldRequest request, final ApiCallback<FormFieldResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateFormFieldValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FormFieldResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateParagraphFormat
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateParagraphFormatCall(UpdateParagraphFormatRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getDto();

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/paragraphs/{index}/format"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateParagraphFormatValidateBeforeCall(UpdateParagraphFormatRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling updateParagraphFormat");
        }
        
        // verify the required parameter 'Dto' is set
        if (request.getDto() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Dto' when calling updateParagraphFormat");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling updateParagraphFormat");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling updateParagraphFormat");
        }
        

        com.squareup.okhttp.Call call = updateParagraphFormatCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates paragraph format properties, returns updated format properties.
     * 
     * @return ParagraphFormatResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ParagraphFormatResponse updateParagraphFormat(UpdateParagraphFormatRequest request) throws ApiException {
        try {
            ApiResponse<ParagraphFormatResponse> resp = updateParagraphFormatWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<ParagraphFormatResponse> resp = updateParagraphFormatWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates paragraph format properties, returns updated format properties.
     * 
     * @return ApiResponse&lt;ParagraphFormatResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<ParagraphFormatResponse> updateParagraphFormatWithHttpInfo(UpdateParagraphFormatRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateParagraphFormatValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<ParagraphFormatResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates paragraph format properties, returns updated format properties. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateParagraphFormatAsync(UpdateParagraphFormatRequest request, final ApiCallback<ParagraphFormatResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateParagraphFormatValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ParagraphFormatResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateRun
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateRunCall(UpdateRunRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getRun();

        // create path and map variables
        String localVarPath = "/words/{name}/{paragraphPath}/runs/{index}"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "paragraphPath" + "\\}", apiClient.escapeString(request.getParagraphPath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateRunValidateBeforeCall(UpdateRunRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling updateRun");
        }
        
        // verify the required parameter 'Run' is set
        if (request.getRun() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Run' when calling updateRun");
        }
        
        // verify the required parameter 'ParagraphPath' is set
        if (request.getParagraphPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'ParagraphPath' when calling updateRun");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling updateRun");
        }
        

        com.squareup.okhttp.Call call = updateRunCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates run&#39;s properties, returns updated run&#39;s data.
     * 
     * @return RunResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public RunResponse updateRun(UpdateRunRequest request) throws ApiException {
        try {
            ApiResponse<RunResponse> resp = updateRunWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<RunResponse> resp = updateRunWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates run&#39;s properties, returns updated run&#39;s data.
     * 
     * @return ApiResponse&lt;RunResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<RunResponse> updateRunWithHttpInfo(UpdateRunRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateRunValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<RunResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates run&#39;s properties, returns updated run&#39;s data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateRunAsync(UpdateRunRequest request, final ApiCallback<RunResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateRunValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<RunResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateRunFont
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateRunFontCall(UpdateRunFontRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getFontDto();

        // create path and map variables
        String localVarPath = "/words/{name}/{paragraphPath}/runs/{index}/font"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "paragraphPath" + "\\}", apiClient.escapeString(request.getParagraphPath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateRunFontValidateBeforeCall(UpdateRunFontRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling updateRunFont");
        }
        
        // verify the required parameter 'FontDto' is set
        if (request.getFontDto() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'FontDto' when calling updateRunFont");
        }
        
        // verify the required parameter 'ParagraphPath' is set
        if (request.getParagraphPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'ParagraphPath' when calling updateRunFont");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling updateRunFont");
        }
        

        com.squareup.okhttp.Call call = updateRunFontCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates font properties, returns updated font data.
     * 
     * @return FontResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FontResponse updateRunFont(UpdateRunFontRequest request) throws ApiException {
        try {
            ApiResponse<FontResponse> resp = updateRunFontWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FontResponse> resp = updateRunFontWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates font properties, returns updated font data.
     * 
     * @return ApiResponse&lt;FontResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FontResponse> updateRunFontWithHttpInfo(UpdateRunFontRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateRunFontValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FontResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates font properties, returns updated font data. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateRunFontAsync(UpdateRunFontRequest request, final ApiCallback<FontResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateRunFontValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FontResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateSectionPageSetup
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateSectionPageSetupCall(UpdateSectionPageSetupRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getPageSetup();

        // create path and map variables
        String localVarPath = "/words/{name}/sections/{sectionIndex}/pageSetup"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "sectionIndex" + "\\}", apiClient.escapeString(request.getSectionIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateSectionPageSetupValidateBeforeCall(UpdateSectionPageSetupRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling updateSectionPageSetup");
        }
        
        // verify the required parameter 'SectionIndex' is set
        if (request.getSectionIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'SectionIndex' when calling updateSectionPageSetup");
        }
        
        // verify the required parameter 'PageSetup' is set
        if (request.getPageSetup() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'PageSetup' when calling updateSectionPageSetup");
        }
        

        com.squareup.okhttp.Call call = updateSectionPageSetupCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates page setup of section.
     * 
     * @return SectionPageSetupResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SectionPageSetupResponse updateSectionPageSetup(UpdateSectionPageSetupRequest request) throws ApiException {
        try {
            ApiResponse<SectionPageSetupResponse> resp = updateSectionPageSetupWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<SectionPageSetupResponse> resp = updateSectionPageSetupWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates page setup of section.
     * 
     * @return ApiResponse&lt;SectionPageSetupResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<SectionPageSetupResponse> updateSectionPageSetupWithHttpInfo(UpdateSectionPageSetupRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateSectionPageSetupValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<SectionPageSetupResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates page setup of section. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateSectionPageSetupAsync(UpdateSectionPageSetupRequest request, final ApiCallback<SectionPageSetupResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateSectionPageSetupValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SectionPageSetupResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateTableCellFormat
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateTableCellFormatCall(UpdateTableCellFormatRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getFormat();

        // create path and map variables
        String localVarPath = "/words/{name}/{tableRowPath}/cells/{index}/cellformat"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "tableRowPath" + "\\}", apiClient.escapeString(request.getTableRowPath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateTableCellFormatValidateBeforeCall(UpdateTableCellFormatRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling updateTableCellFormat");
        }
        
        // verify the required parameter 'TableRowPath' is set
        if (request.getTableRowPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'TableRowPath' when calling updateTableCellFormat");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling updateTableCellFormat");
        }
        

        com.squareup.okhttp.Call call = updateTableCellFormatCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates a table cell format.
     * 
     * @return TableCellFormatResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TableCellFormatResponse updateTableCellFormat(UpdateTableCellFormatRequest request) throws ApiException {
        try {
            ApiResponse<TableCellFormatResponse> resp = updateTableCellFormatWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TableCellFormatResponse> resp = updateTableCellFormatWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates a table cell format.
     * 
     * @return ApiResponse&lt;TableCellFormatResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TableCellFormatResponse> updateTableCellFormatWithHttpInfo(UpdateTableCellFormatRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateTableCellFormatValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TableCellFormatResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates a table cell format. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateTableCellFormatAsync(UpdateTableCellFormatRequest request, final ApiCallback<TableCellFormatResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateTableCellFormatValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TableCellFormatResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateTableProperties
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateTablePropertiesCall(UpdateTablePropertiesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getProperties();

        // create path and map variables
        String localVarPath = "/words/{name}/{nodePath}/tables/{index}/properties"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()))
            .replaceAll("\\{" + "nodePath" + "\\}", apiClient.escapeString(request.getNodePath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateTablePropertiesValidateBeforeCall(UpdateTablePropertiesRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling updateTableProperties");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling updateTableProperties");
        }
        
        // verify the required parameter 'NodePath' is set
        if (request.getNodePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'NodePath' when calling updateTableProperties");
        }
        

        com.squareup.okhttp.Call call = updateTablePropertiesCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates a table properties.
     * 
     * @return TablePropertiesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TablePropertiesResponse updateTableProperties(UpdateTablePropertiesRequest request) throws ApiException {
        try {
            ApiResponse<TablePropertiesResponse> resp = updateTablePropertiesWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TablePropertiesResponse> resp = updateTablePropertiesWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates a table properties.
     * 
     * @return ApiResponse&lt;TablePropertiesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TablePropertiesResponse> updateTablePropertiesWithHttpInfo(UpdateTablePropertiesRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateTablePropertiesValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TablePropertiesResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates a table properties. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateTablePropertiesAsync(UpdateTablePropertiesRequest request, final ApiCallback<TablePropertiesResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateTablePropertiesValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TablePropertiesResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateTableRowFormat
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call updateTableRowFormatCall(UpdateTableRowFormatRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request.getFormat();

        // create path and map variables
        String localVarPath = "/words/{name}/{tablePath}/rows/{index}/rowformat"
            .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(request.getName().toString()))
            .replaceAll("\\{" + "tablePath" + "\\}", apiClient.escapeString(request.getTablePath().toString()))
            .replaceAll("\\{" + "index" + "\\}", apiClient.escapeString(request.getIndex().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "folder", request.getFolder());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storage", request.getStorage());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "loadEncoding", request.getLoadEncoding());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "password", request.getPassword());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "destFileName", request.getDestFileName());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionAuthor", request.getRevisionAuthor());
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "revisionDateTime", request.getRevisionDateTime());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/xml", "application/json"
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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateTableRowFormatValidateBeforeCall(UpdateTableRowFormatRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'Name' is set
        if (request.getName() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Name' when calling updateTableRowFormat");
        }
        
        // verify the required parameter 'TablePath' is set
        if (request.getTablePath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'TablePath' when calling updateTableRowFormat");
        }
        
        // verify the required parameter 'Index' is set
        if (request.getIndex() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Index' when calling updateTableRowFormat");
        }
        

        com.squareup.okhttp.Call call = updateTableRowFormatCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Updates a table row format.
     * 
     * @return TableRowFormatResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TableRowFormatResponse updateTableRowFormat(UpdateTableRowFormatRequest request) throws ApiException {
        try {
            ApiResponse<TableRowFormatResponse> resp = updateTableRowFormatWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<TableRowFormatResponse> resp = updateTableRowFormatWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Updates a table row format.
     * 
     * @return ApiResponse&lt;TableRowFormatResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<TableRowFormatResponse> updateTableRowFormatWithHttpInfo(UpdateTableRowFormatRequest request) throws ApiException {
        com.squareup.okhttp.Call call = updateTableRowFormatValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<TableRowFormatResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Updates a table row format. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateTableRowFormatAsync(UpdateTableRowFormatRequest request, final ApiCallback<TableRowFormatResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateTableRowFormatValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TableRowFormatResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for uploadFile
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call uploadFileCall(UploadFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/words/storage/file/{path}"
            .replaceAll("\\{" + "path" + "\\}", apiClient.escapeString(request.getPath().toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        localVarPath = addParameterToQuery(localVarQueryParams, localVarPath, "storageName", request.getStorageName());

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        Map<String, Object> localVarFormParams = new LinkedHashMap<String, Object>();
        if (request.getFile() != null)
          localVarFormParams.put("File", request.getFile());

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

        String[] localVarAuthNames = new String[] { "JWT" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call uploadFileValidateBeforeCall(UploadFileRequest request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'File' is set
        if (request.getFile() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'File' when calling uploadFile");
        }
        
        // verify the required parameter 'Path' is set
        if (request.getPath() == null) {
          throw new ApiException(BadRequest, "Missing the required parameter 'Path' when calling uploadFile");
        }
        

        com.squareup.okhttp.Call call = uploadFileCall(request, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Upload file
     * 
     * @return FilesUploadResult
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FilesUploadResult uploadFile(UploadFileRequest request) throws ApiException {
        try {
            ApiResponse<FilesUploadResult> resp = uploadFileWithHttpInfo(request);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.requestToken();
                ApiResponse<FilesUploadResult> resp = uploadFileWithHttpInfo(request);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Upload file
     * 
     * @return ApiResponse&lt;FilesUploadResult&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<FilesUploadResult> uploadFileWithHttpInfo(UploadFileRequest request) throws ApiException {
        com.squareup.okhttp.Call call = uploadFileValidateBeforeCall(request, null, null);
        Type localVarReturnType = new TypeToken<FilesUploadResult>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Upload file (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call uploadFileAsync(UploadFileRequest request, final ApiCallback<FilesUploadResult> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = uploadFileValidateBeforeCall(request, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FilesUploadResult>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }

      /**
     * Build call for putCreate
     * @param path Path where to upload including filename and extension e.g. /file.ext or /Folder 1/file.ext (required)
     * @param file File to upload (required)
     * @param versionId Source file&#39;s version (optional)
     * @param storage User&#39;s storage name (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    private com.squareup.okhttp.Call putCreateCall(String path, File file, String versionId, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = file;

        // create path and map variables
        String localVarPath = "/storage/file";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (path != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("path", path));
        if (versionId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("versionId", versionId));
        if (storage != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("storage", storage));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };

        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
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

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putCreateValidateBeforeCall(String path, File file, String versionId, String storage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'path' is set
        if (path == null) {
            throw new ApiException("Missing the required parameter 'path' when calling putCreate(Async)");
        }
        
        // verify the required parameter 'file' is set
        if (file == null) {
            throw new ApiException("Missing the required parameter 'file' when calling putCreate(Async)");
        }
        

        com.squareup.okhttp.Call call = putCreateCall(path, file, versionId, storage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Upload a specific file 
     * 
     * @param path Path where to upload including filename and extension e.g. /file.ext or /Folder 1/file.ext (required)
     * @param file File to upload (required)
     * @param versionId Source file&#39;s version (optional)
     * @param storage User&#39;s storage name (optional)
     * @return AsposeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AsposeResponse putCreate(String path, File file, String versionId, String storage) throws ApiException {
        try {
            ApiResponse<AsposeResponse> resp = putCreateWithHttpInfo(path, file, versionId, storage);
            return resp.getData();
        }
        catch (ApiException ex) {
            if (ex.getCode() == NotAuth) {
                apiClient.refreshToken();
                ApiResponse<AsposeResponse> resp = putCreateWithHttpInfo(path, file, versionId, storage);
                return resp.getData();
            }
            throw ex;
        }
    }

    /**
     * Upload a specific file 
     * 
     * @param path Path where to upload including filename and extension e.g. /file.ext or /Folder 1/file.ext (required)
     * @param file File to upload (required)
     * @param versionId Source file&#39;s version (optional)
     * @param storage User&#39;s storage name (optional)
     * @return ApiResponse&lt;AsposeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    private ApiResponse<AsposeResponse> putCreateWithHttpInfo(String path, File file, String versionId, String storage) throws ApiException {
        com.squareup.okhttp.Call call = putCreateValidateBeforeCall(path, file, versionId, storage, null, null);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Upload a specific file  (asynchronously)
     * 
     * @param path Path where to upload including filename and extension e.g. /file.ext or /Folder 1/file.ext (required)
     * @param file File to upload (required)
     * @param versionId Source file&#39;s version (optional)
     * @param storage User&#39;s storage name (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putCreateAsync(String path, File file, String versionId, String storage, final ApiCallback<AsposeResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putCreateValidateBeforeCall(path, file, versionId, storage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AsposeResponse>() { }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }

    private String addParameterToQuery(List<Pair> queryParams, String path, String paramName, Object paramValue) {
        if (path.contains("{" + paramName + "}")) {
            if (paramValue == null || paramValue.equals("")) {
                return path.replace("{" + paramName + "}", "");
            } 
            else {
                return path.replace("{" + paramName + "}", paramValue.toString());
            }
        }

        queryParams.addAll(apiClient.parameterToPair(paramName, paramValue));
        return path;
    }
}
/*