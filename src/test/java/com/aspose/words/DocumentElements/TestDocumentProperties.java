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

import com.aspose.words.ApiException;
import com.aspose.words.StringUtil;
import com.aspose.words.TestInitializer;
import com.aspose.words.model.*;
import com.aspose.words.model.requests.*;
import junit.framework.TestCase;

public class TestDocumentProperties extends TestCase {
    private String testFolder = "DocumentElements/DocumentProperties";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        TestInitializer.Initialize();
    }

    /*
     * Test for adding/updating document property
     */
    public void testCreateOrUpdateDocumentProperty() throws ApiException {
        String fileName = "test_multi_pages.docx";
        String remoteName = "TestPutUpdateDocumentProperty.docx";
        String propertyName = "AsposeAuthor";
        DocumentProperty prop = new DocumentProperty().builtIn(false).name(propertyName).value("Yaroslaw Ekimov");

        TestInitializer.uploadFile(StringUtil.join("/", TestInitializer.RemoteTestFolder, testFolder, remoteName).replace("\\", "/"),
                StringUtil.join("/", TestInitializer.LocalCommonFolder, fileName));

        CreateOrUpdateDocumentPropertyRequest request = new CreateOrUpdateDocumentPropertyRequest(remoteName, propertyName,
                prop, StringUtil.join("/", TestInitializer.RemoteTestFolder, testFolder),
                null, null, null, null, null, null);

        DocumentPropertyResponse result = TestInitializer.wordsApi.createOrUpdateDocumentProperty(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }

    /*
     * Test for deleting document property
     */
    public void testDeleteDocumentProperty() throws ApiException {
        String fileName = "test_multi_pages.docx";
        String remoteName = "TestDeleteDocumentProperty.docx";
        String propertyName = "testProp";
        String destName = StringUtil.join("/", TestInitializer.RemoteTestOut, remoteName);

        TestInitializer.uploadFile(StringUtil.join("/", TestInitializer.RemoteTestFolder, testFolder, remoteName).replace("\\", "/"),
                StringUtil.join("/", TestInitializer.LocalCommonFolder, fileName));

        DeleteDocumentPropertyRequest request = new DeleteDocumentPropertyRequest(remoteName, propertyName,
                StringUtil.join("/", TestInitializer.RemoteTestFolder, testFolder),
                null, null, null, destName, null, null);

        AsposeResponse result = TestInitializer.wordsApi.deleteDocumentProperty(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }

    /*
     * Test for getting document properties
     */
    public void testGetDocumentProperties() throws ApiException {
        String fileName = "test_multi_pages.docx";
        String remoteName = "TestGetDocumentProperties.docx";

        TestInitializer.uploadFile(StringUtil.join("/", TestInitializer.RemoteTestFolder, testFolder, remoteName).replace("\\", "/"),
                StringUtil.join("/", TestInitializer.LocalCommonFolder, fileName));

        GetDocumentPropertiesRequest request = new GetDocumentPropertiesRequest(remoteName,
                StringUtil.join("/", TestInitializer.RemoteTestFolder, testFolder),
                null, null, null);

        DocumentPropertiesResponse result = TestInitializer.wordsApi.getDocumentProperties(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }

    /*
     * Test for getting document property
     */
    public void testGetDocumentProperty() throws ApiException {
        String fileName = "test_multi_pages.docx";
        String remoteName = "TestGetDocumentProperty.docx";
        String propName = "Author";

        TestInitializer.uploadFile(StringUtil.join("/", TestInitializer.RemoteTestFolder, testFolder, remoteName).replace("\\", "/"),
                StringUtil.join("/", TestInitializer.LocalCommonFolder, fileName));

        GetDocumentPropertyRequest request = new GetDocumentPropertyRequest(remoteName, propName,
                StringUtil.join("/", TestInitializer.RemoteTestFolder, testFolder),
                null, null, null);

        DocumentPropertyResponse result = TestInitializer.wordsApi.getDocumentProperty(request);
        assertEquals(result.getCode(), Integer.valueOf(200));
    }
}
