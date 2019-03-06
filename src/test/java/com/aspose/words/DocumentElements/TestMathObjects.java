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
package com.aspose.words.cloud.DocumentElements;

import com.aspose.words.cloud.ApiException;
import com.aspose.words.cloud.TestInitializer;
import com.aspose.words.cloud.model.AsposeResponse;
import com.aspose.words.cloud.model.OfficeMathObjectResponse;
import com.aspose.words.cloud.model.OfficeMathObjectsResponse;
import com.aspose.words.cloud.model.requests.*;
import junit.framework.TestCase;

import java.io.File;
import java.nio.file.Paths;

public class TestMathObjects extends TestCase {
    private String testFolder = "DocumentElements/MathObjects";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        TestInitializer.Initialize();
    }

    /*
     * Test for removing math object from document
     */
    public void testDeleteOfficeMathObject() throws ApiException {
        String fileName = "MathObjects.docx";
        String remoteName = "TestDeleteOfficeMathObject.doc";
        Integer index = 0;
        TestInitializer.wordsApi.putCreate(Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"),
                new File(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString()),
                null, null);

        DeleteOfficeMathObjectRequest request = new DeleteOfficeMathObjectRequest(remoteName, index,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null, null, null, null);

        AsposeResponse result = TestInitializer.wordsApi.deleteOfficeMathObject(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }

    /*
     * Test for getting math object from document
     */
    public void testGetOfficeMathObject() throws ApiException {
        String fileName = "MathObjects.docx";
        String remoteName = "TestGetOfficeMathObject.doc";
        Integer index = 0;
        TestInitializer.wordsApi.putCreate(Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"),
                new File(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString()),
                null, null);

        GetOfficeMathObjectRequest request = new GetOfficeMathObjectRequest(remoteName, index,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null);

        OfficeMathObjectResponse result = TestInitializer.wordsApi.getOfficeMathObject(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }

    /*
     * Test for getting math objects from document
     */
    public void testGetOfficeMathObjects() throws ApiException {
        String fileName = "MathObjects.docx";
        String remoteName = "TestGetOfficeMathObjects.doc";
        TestInitializer.wordsApi.putCreate(Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"),
                new File(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString()),
                null, null);

        GetOfficeMathObjectsRequest request = new GetOfficeMathObjectsRequest(remoteName,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null);

        OfficeMathObjectsResponse result = TestInitializer.wordsApi.getOfficeMathObjects(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }

    /*
     * Test for getting math objects from document
     */
    public void testRenderMathObject() throws ApiException {
        String fileName = "MathObjects.docx";
        String remoteName = "TestRenderMathObject.doc";
        Integer index = 0;
        String format = "png";
        TestInitializer.wordsApi.putCreate(Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"),
                new File(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString()),
                null, null);

        RenderMathObjectRequest request = new RenderMathObjectRequest(remoteName, format, index,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null, null);

        File result = TestInitializer.wordsApi.renderMathObject(request);
        assertTrue(result.length() > 0);
    }
}
