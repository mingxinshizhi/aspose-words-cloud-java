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
import com.aspose.words.StringUtil;
import com.aspose.words.TestInitializer;
import com.aspose.words.model.FieldNamesResponse;
import com.aspose.words.model.requests.GetDocumentFieldNamesRequest;
import com.aspose.words.model.requests.PutDocumentFieldNamesRequest;
import junit.framework.TestCase;

import java.io.File;

public class TestMailMergeFields extends TestCase {
    private String testFolder = "DocumentActions/MailMerge";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        TestInitializer.Initialize();
    }

    /*
     * Test for getting document field names
     */
    public void testGetDocumentFieldNames() throws ApiException {
        String fileName = "test_multi_pages.docx";
        String remoteName = "TestGetDocumentFieldNames.docx";

        TestInitializer.uploadFile(StringUtil.join("/", TestInitializer.RemoteTestFolder, testFolder, remoteName).replace("\\", "/"),
                StringUtil.join("/", TestInitializer.LocalCommonFolder, fileName));

        GetDocumentFieldNamesRequest request = new GetDocumentFieldNamesRequest(remoteName,
                StringUtil.join("/", TestInitializer.RemoteTestFolder, testFolder),
                null, null, null, null);

        FieldNamesResponse result = TestInitializer.wordsApi.getDocumentFieldNames(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }

    /*
     * Test for executing mail merge online
     */
    public void testPutDocumentFieldNames() throws ApiException {
        String fileName = "SampleExecuteTemplate.docx";
        File file = new File(StringUtil.join("/", TestInitializer.LocalTestFolder, testFolder, fileName));

        PutDocumentFieldNamesRequest request = new PutDocumentFieldNamesRequest(file, true);

        FieldNamesResponse result = TestInitializer.wordsApi.putDocumentFieldNames(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }
}
