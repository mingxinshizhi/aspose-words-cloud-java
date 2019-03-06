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
import com.aspose.words.cloud.model.Run;
import com.aspose.words.cloud.model.RunResponse;
import com.aspose.words.cloud.model.requests.DeleteRunRequest;
import com.aspose.words.cloud.model.requests.PostRunRequest;
import com.aspose.words.cloud.model.requests.PutRunRequest;
import junit.framework.TestCase;

import java.io.File;
import java.nio.file.Paths;

public class TestRuns extends TestCase {
    private String testFolder = "DocumentElements/Runs";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        TestInitializer.Initialize();
    }

    /*
     * Test for removing run
     */
    public void testDeleteRun() throws ApiException {
        String fileName = "Run.doc";
        String remoteName = "TestDeleteRun.doc";
        Integer index = 0;
        String paragraphPath = "paragraphs/1";
        TestInitializer.wordsApi.putCreate(Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"),
                new File(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString()),
                null, null);

        DeleteRunRequest request = new DeleteRunRequest(remoteName, paragraphPath, index,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null, null, null);

        AsposeResponse result = TestInitializer.wordsApi.deleteRun(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }

    /*
     * Test for updating run
     */
    public void testPostRun() throws ApiException {
        String fileName = "Run.doc";
        String remoteName = "TestPostRun.doc";
        Integer index = 0;
        String paragraphPath = "paragraphs/1";
        Run body = (Run) new Run().text("Run with text");
        TestInitializer.wordsApi.putCreate(Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"),
                new File(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString()),
                null, null);

        PostRunRequest request = new PostRunRequest(remoteName, body, paragraphPath, index,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null, null, null);

        RunResponse result = TestInitializer.wordsApi.postRun(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }

    /*
     * Test for inserting run
     */
    public void testPutRun() throws ApiException {
        String fileName = "Run.doc";
        String remoteName = "TestPutRun.doc";
        String paragraphPath = "paragraphs/1";
        Run body = (Run) new Run().text("Run with text");
        TestInitializer.wordsApi.putCreate(Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"),
                new File(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString()),
                null, null);

        PutRunRequest request = new PutRunRequest(remoteName, paragraphPath, body,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null, null, null, null);

        RunResponse result = TestInitializer.wordsApi.putRun(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }
}
