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
package com.aspose.words.DocumentElements;

import java.io.FileNotFoundException;
import java.nio.file.Paths;

import com.aspose.words.ApiException;
import com.aspose.words.TestInitializer;
import com.aspose.words.model.HeaderFooterResponse;
import com.aspose.words.model.HeaderFootersResponse;
import com.aspose.words.model.WordsResponse;
import com.aspose.words.model.requests.DeleteHeaderFooterRequest;
import com.aspose.words.model.requests.GetHeaderFooterOfSectionRequest;
import com.aspose.words.model.requests.GetHeaderFooterRequest;
import com.aspose.words.model.requests.GetHeaderFootersRequest;
import com.aspose.words.model.requests.InsertHeaderFooterRequest;

import junit.framework.TestCase;

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
    public void testPutHeaderFooter() throws ApiException, FileNotFoundException {
        String fileName = "HeadersFooters.doc";
        String remoteName = "TestPutHeaderFooter.doc";
        String footerType = "FooterEven";
        TestInitializer.UploadFile(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString(), Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"));

        InsertHeaderFooterRequest request = new InsertHeaderFooterRequest(remoteName, footerType,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null, null, null, null);

        HeaderFooterResponse result = TestInitializer.wordsApi.insertHeaderFooter(request);
        assertNotNull(result);
    }

    /*
     * Test for getting header or footer
     */
    public void testGetHeaderFooter() throws ApiException, FileNotFoundException {
        String fileName = "HeadersFooters.doc";
        String remoteName = "TestGetHeaderFooter.doc";
        Integer index = 0;
        TestInitializer.UploadFile(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString(), Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"));

        GetHeaderFooterRequest request = new GetHeaderFooterRequest(remoteName, index,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null);

        HeaderFooterResponse result = TestInitializer.wordsApi.getHeaderFooter(request);
        assertNotNull(result);
    }

    /*
     * Test for getting headers or footers
     */
    public void testGetHeaderFooters() throws ApiException, FileNotFoundException {
        String fileName = "HeadersFooters.doc";
        String remoteName = "TestGetHeaderFooters.doc";
        TestInitializer.UploadFile(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString(), Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"));

        GetHeaderFootersRequest request = new GetHeaderFootersRequest(remoteName, "",
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null);

        HeaderFootersResponse result = TestInitializer.wordsApi.getHeaderFooters(request);
        assertNotNull(result);
    }

    /*
     * Test for getting section headers/footers
     */
    public void testGetHeaderFooterOfSection() throws ApiException, FileNotFoundException {
        String fileName = "HeadersFooters.doc";
        String remoteName = "TestGetHeaderFooterOfSection.doc";
        Integer index = 0;
        Integer sectionIndex = 0;
        TestInitializer.UploadFile(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString(), Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"));

        GetHeaderFooterOfSectionRequest request = new GetHeaderFooterOfSectionRequest(remoteName, index, sectionIndex,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null);

        HeaderFooterResponse result = TestInitializer.wordsApi.getHeaderFooterOfSection(request);
        assertNotNull(result);
    }

    /*
     * Test for removing header/footer
     */
    public void testDeleteHeaderFooter() throws ApiException, FileNotFoundException {
        String fileName = "HeadersFooters.doc";
        String remoteName = "TestDeleteHeaderFooter.doc";
        Integer index = 0;
        TestInitializer.UploadFile(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString(), Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"));

        DeleteHeaderFooterRequest request = new DeleteHeaderFooterRequest(remoteName, "", index,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null, null, null);

        TestInitializer.wordsApi.deleteHeaderFooter(request);
    }

    /*
     * Test for removing headers/footers
     */
    public void testDeleteHeadersFooters() throws ApiException, FileNotFoundException {
        String fileName = "HeadersFooters.doc";
        String remoteName = "TestDeleteHeadersFooters.doc";
        Integer index = 0;
        TestInitializer.UploadFile(Paths.get(TestInitializer.LocalTestFolder, testFolder, fileName).toString(), Paths.get(TestInitializer.RemoteTestFolder, testFolder, remoteName).toString().replace("\\", "/"));

        DeleteHeaderFooterRequest request = new DeleteHeaderFooterRequest(remoteName, "", index,
                Paths.get(TestInitializer.RemoteTestFolder, testFolder).toString(), null, null,
                null, null, null, null);

        TestInitializer.wordsApi.deleteHeaderFooter(request);
    }
}
