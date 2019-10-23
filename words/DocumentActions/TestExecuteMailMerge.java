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
package com.aspose.words.DocumentActions;

import com.aspose.words.ApiException;
import com.aspose.words.TestInitializer;
import com.aspose.words.model.DocumentResponse;
import com.aspose.words.model.requests.PostDocumentExecuteMailMergeRequest;
import com.aspose.words.model.requests.PutExecuteMailMergeOnlineRequest;
import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestExecuteMailMerge extends TestCase {
    private String testFolder = "DocumentActions/MailMerge";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        TestInitializer.Initialize();
    }

    /*
     * Test for mail merge execution
     */
    public void testPostDocumentExecuteMailMerge() throws ApiException, IOException {
        String fileName = "SampleMailMergeTemplate.docx";
        String remoteName = "TestPostDocumentExecuteMailMerge.docx";
        String destName = Paths.get(TestInitializer.RemoteTestOut, remoteName).toString();
        TestInitializer.uploadFile(Paths.get(TestInitializer.LocalCommonFolder, fileName).ToString(), Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"));
        String data = new String(Files.readAllBytes(Paths.get(TestInitializer.LocalTestFolder, testFolder, "SampleMailMergeTemplateData.txt")), "utf8");

        PostDocumentExecuteMailMergeRequest request = new PostDocumentExecuteMailMergeRequest(remoteName, data,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(),
                null, null, null, null, null, null,
                null, destName);

        DocumentResponse result = TestInitializer.wordsApi.postDocumentExecuteMailMerge(request);
        assertNotNull(result);
    }

    /*
     * Test for executing mail merge online
     */
    public void testPutExecuteMailMergeOnline() throws ApiException {
        String fileName = "SampleMailMergeTemplate.docx";
        File file = Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toFile();
        File data = Paths.get(TestInitializer.LocalTestFolder, testFolder, "SampleMailMergeTemplateData.txt").toFile();

        PutExecuteMailMergeOnlineRequest request = new PutExecuteMailMergeOnlineRequest(file, data,
                null, null, null);

        File result = TestInitializer.wordsApi.putExecuteMailMergeOnline(request);
        assertTrue(result.length() > 0);
    }
}
