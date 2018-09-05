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
package com.aspose.words.Document;

import com.aspose.words.ApiException;
import com.aspose.words.TestInitializer;
import com.aspose.words.model.DocumentResponse;
import com.aspose.words.model.requests.GetDocumentRequest;
import com.aspose.words.model.requests.PutCreateDocumentRequest;
import junit.framework.TestCase;

import java.io.File;
import java.nio.file.Paths;

public class TestDocument extends TestCase {
    private String testFolder = "document";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        TestInitializer.Initialize();
    }

    /*
        Test for getting document
     */
    public void testGetDocument(){
        String fileName = "test_multi_pages.docx";
        String remoteName = "TestGetDocument.docx";
        try {
            TestInitializer.wordApi.putCreate(Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"),
                    new File(Paths.get(TestInitializer.LocalCommonFolder, fileName).toString()),
                    null, null);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        GetDocumentRequest request = new GetDocumentRequest(remoteName,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(),
                null, null, null);
        try {
            DocumentResponse result = TestInitializer.wordApi.getDocument(request);
            assertEquals(result.getCode(), Integer.valueOf(200));
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    /*
        Test for creating document
    */
    public void testPutCreateDocument(){
        String fileName = "test_multi_pages.docx";
        String remoteName = "TestPutCreateDocument.docx";
        try {
            TestInitializer.wordApi.putCreate(Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"),
                    new File(Paths.get(TestInitializer.LocalCommonFolder, fileName).toString()),
                    null, null);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        PutCreateDocumentRequest request = new PutCreateDocumentRequest(null, remoteName,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString());
        try {
            DocumentResponse result = TestInitializer.wordApi.putCreateDocument(request);
            assertEquals(result.getCode(), Integer.valueOf(200));
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
