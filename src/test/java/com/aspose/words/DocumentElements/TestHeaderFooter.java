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
import com.aspose.words.cloud.model.*;
import com.aspose.words.cloud.model.requests.*;
import junit.framework.TestCase;

import java.io.File;
import java.nio.file.Paths;

public class TestHeaderFooter extends TestCase {
    private String testFolder = "DocumentElements/HeaderFooters";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        TestInitializer.Initialize();
    }

    /*
     * Test for updating footnote from document
     */
    public void testPutHeaderFooter() throws ApiException {
        String fileName = "HeadersFooters.doc";
        String remoteName = "TestPutHeaderFooter.doc";
        String footerType = "FooterEven";
        TestInitializer.wordsApi.putCreate(Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"),
                new File(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString()),
                null, null);

        PutHeaderFooterRequest request = new PutHeaderFooterRequest(remoteName, footerType,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null, null, null, null);

        HeaderFooterResponse result = TestInitializer.wordsApi.putHeaderFooter(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }

    /*
     * Test for getting header or footer
     */
    public void testGetHeaderFooter() throws ApiException {
        String fileName = "HeadersFooters.doc";
        String remoteName = "TestGetHeaderFooter.doc";
        Integer index = 0;
        TestInitializer.wordsApi.putCreate(Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"),
                new File(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString()),
                null, null);

        GetHeaderFooterRequest request = new GetHeaderFooterRequest(remoteName, index,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null);

        HeaderFooterResponse result = TestInitializer.wordsApi.getHeaderFooter(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }

    /*
     * Test for getting headers or footers
     */
    public void testGetHeaderFooters() throws ApiException {
        String fileName = "HeadersFooters.doc";
        String remoteName = "TestGetHeaderFooters.doc";
        TestInitializer.wordsApi.putCreate(Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"),
                new File(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString()),
                null, null);

        GetHeaderFootersRequest request = new GetHeaderFootersRequest(remoteName,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null, null);

        HeaderFootersResponse result = TestInitializer.wordsApi.getHeaderFooters(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }

    /*
     * Test for getting section headers/footers
     */
    public void testGetHeaderFooterOfSection() throws ApiException {
        String fileName = "HeadersFooters.doc";
        String remoteName = "TestGetHeaderFooterOfSection.doc";
        Integer index = 0;
        Integer sectionIndex = 0;
        TestInitializer.wordsApi.putCreate(Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"),
                new File(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString()),
                null, null);

        GetHeaderFooterOfSectionRequest request = new GetHeaderFooterOfSectionRequest(remoteName, index, sectionIndex,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null);

        HeaderFooterResponse result = TestInitializer.wordsApi.getHeaderFooterOfSection(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }

    /*
     * Test for removing header/footer
     */
    public void testDeleteHeaderFooter() throws ApiException {
        String fileName = "HeadersFooters.doc";
        String remoteName = "TestDeleteHeaderFooter.doc";
        Integer index = 0;
        TestInitializer.wordsApi.putCreate(Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"),
                new File(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString()),
                null, null);

        DeleteHeaderFooterRequest request = new DeleteHeaderFooterRequest(remoteName, index,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null, null, null, null);

        AsposeResponse result = TestInitializer.wordsApi.deleteHeaderFooter(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }

    /*
     * Test for removing headers/footers
     */
    public void testDeleteHeadersFooters() throws ApiException {
        String fileName = "HeadersFooters.doc";
        String remoteName = "TestDeleteHeadersFooters.doc";
        Integer index = 0;
        TestInitializer.wordsApi.putCreate(Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"),
                new File(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString()),
                null, null);

        DeleteHeaderFooterRequest request = new DeleteHeaderFooterRequest(remoteName, index,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null, null, null, null);

        AsposeResponse result = TestInitializer.wordsApi.deleteHeaderFooter(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }
}
