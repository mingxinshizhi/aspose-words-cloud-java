/*
 * --------------------------------------------------------------------------------
 * <copyright company="Aspose" file="TestField.java">
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

package com.aspose.words.cloud.api.field;

import com.aspose.words.cloud.*;
import com.aspose.words.cloud.model.*;
import com.aspose.words.cloud.model.requests.*;
import com.aspose.words.cloud.model.responses.*;
import junit.framework.TestCase;
import org.junit.Test;
import org.threeten.bp.*;
import java.io.File;
import java.io.IOException;
import javax.mail.MessagingException;
import java.nio.file.*;
import java.util.ArrayList;

/*
 * Example of how to work with field.
 */
public class TestField  extends TestCase
{
    private String remoteDataFolder = TestInitializer.RemoteTestFolder + "/DocumentElements/Fields";
    private String textFolder = "DocumentElements/Text";
    private String fieldFolder = "DocumentElements/Fields";


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        TestInitializer.Initialize();
    }

    /*
     * Test for getting fields.
     */
    @Test
    public void testGetFields() throws ApiException, MessagingException, IOException
    {
        String localFileName = "GetField.docx";
        String remoteFileName = "TestGetFields.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, fieldFolder + "/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        GetFieldsRequest request = new GetFieldsRequest(
            remoteFileName,
            "sections/0",
            remoteDataFolder,
            null,
            null,
            null
        );

        FieldsResponse result = TestInitializer.wordsApi.getFields(request);
        assertNotNull(result);
        assertNotNull(result.getFields());
        assertNotNull(result.getFields().getList());
        assertEquals(1, result.getFields().getList().size());
        assertEquals("1", result.getFields().getList().get(0).getResult());
    }

    /*
     * Test for getting fields online.
     */
    @Test
    public void testGetFieldsOnline() throws ApiException, MessagingException, IOException
    {
        GetFieldsOnlineRequest request = new GetFieldsOnlineRequest(
            Files.readAllBytes(Paths.get(TestInitializer.LocalTestFolder, fieldFolder + "/GetField.docx").toAbsolutePath()),
            "sections/0",
            null,
            null
        );

        FieldsResponse result = TestInitializer.wordsApi.getFieldsOnline(request);
        assertNotNull(result);
    }

    /*
     * Test for getting fields without node path.
     */
    @Test
    public void testGetFieldsWithoutNodePath() throws ApiException, MessagingException, IOException
    {
        String localFileName = "GetField.docx";
        String remoteFileName = "TestGetFieldsWithoutNodePath.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, fieldFolder + "/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        GetFieldsRequest request = new GetFieldsRequest(
            remoteFileName,
            null,
            remoteDataFolder,
            null,
            null,
            null
        );

        FieldsResponse result = TestInitializer.wordsApi.getFields(request);
        assertNotNull(result);
        assertNotNull(result.getFields());
        assertNotNull(result.getFields().getList());
        assertEquals(1, result.getFields().getList().size());
        assertEquals("1", result.getFields().getList().get(0).getResult());
    }

    /*
     * Test for getting field by index.
     */
    @Test
    public void testGetField() throws ApiException, MessagingException, IOException
    {
        String localFileName = "GetField.docx";
        String remoteFileName = "TestGetField.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, fieldFolder + "/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        GetFieldRequest request = new GetFieldRequest(
            remoteFileName,
            0,
            "sections/0/paragraphs/0",
            remoteDataFolder,
            null,
            null,
            null
        );

        FieldResponse result = TestInitializer.wordsApi.getField(request);
        assertNotNull(result);
        assertNotNull(result.getField());
        assertEquals("1", result.getField().getResult());
    }

    /*
     * Test for getting field by index online.
     */
    @Test
    public void testGetFieldOnline() throws ApiException, MessagingException, IOException
    {
        GetFieldOnlineRequest request = new GetFieldOnlineRequest(
            Files.readAllBytes(Paths.get(TestInitializer.LocalTestFolder, fieldFolder + "/GetField.docx").toAbsolutePath()),
            0,
            "sections/0/paragraphs/0",
            null,
            null
        );

        FieldResponse result = TestInitializer.wordsApi.getFieldOnline(request);
        assertNotNull(result);
    }

    /*
     * Test for getting field by index without node path.
     */
    @Test
    public void testGetFieldWithoutNodePath() throws ApiException, MessagingException, IOException
    {
        String localFileName = "GetField.docx";
        String remoteFileName = "TestGetFieldWithoutNodePath.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, fieldFolder + "/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        GetFieldRequest request = new GetFieldRequest(
            remoteFileName,
            0,
            null,
            remoteDataFolder,
            null,
            null,
            null
        );

        FieldResponse result = TestInitializer.wordsApi.getField(request);
        assertNotNull(result);
        assertNotNull(result.getField());
        assertEquals("1", result.getField().getResult());
    }

    /*
     * Test for putting field.
     */
    @Test
    public void testInsertField() throws ApiException, MessagingException, IOException
    {
        String localFileName = "SampleWordDocument.docx";
        String remoteFileName = "TestInsertField.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, textFolder + "/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        FieldInsert requestField = new FieldInsert();
        requestField.setFieldCode("{ NUMPAGES }");

        InsertFieldRequest request = new InsertFieldRequest(
            remoteFileName,
            requestField,
            "sections/0/paragraphs/0",
            remoteDataFolder,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        );

        FieldResponse result = TestInitializer.wordsApi.insertField(request);
        assertNotNull(result);
        assertNotNull(result.getField());
        assertEquals("{ NUMPAGES }", result.getField().getFieldCode());
        assertEquals("0.0.0.1", result.getField().getNodeId());
    }

    /*
     * Test for putting field online.
     */
    @Test
    public void testInsertFieldOnline() throws ApiException, MessagingException, IOException
    {
        FieldInsert requestField = new FieldInsert();
        requestField.setFieldCode("{ NUMPAGES }");

        InsertFieldOnlineRequest request = new InsertFieldOnlineRequest(
            Files.readAllBytes(Paths.get(TestInitializer.LocalTestFolder, fieldFolder + "/GetField.docx").toAbsolutePath()),
            requestField,
            "sections/0/paragraphs/0",
            null,
            null,
            null,
            null,
            null,
            null
        );

        InsertFieldOnlineResponse result = TestInitializer.wordsApi.insertFieldOnline(request);
        assertNotNull(result);
    }

    /*
     * Test for putting field without node path.
     */
    @Test
    public void testInsertFieldWithoutNodePath() throws ApiException, MessagingException, IOException
    {
        String localFileName = "SampleWordDocument.docx";
        String remoteFileName = "TestInsertFieldWithoutNodePath.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, textFolder + "/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        FieldInsert requestField = new FieldInsert();
        requestField.setFieldCode("{ NUMPAGES }");

        InsertFieldRequest request = new InsertFieldRequest(
            remoteFileName,
            requestField,
            null,
            remoteDataFolder,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        );

        FieldResponse result = TestInitializer.wordsApi.insertField(request);
        assertNotNull(result);
        assertNotNull(result.getField());
        assertEquals("{ NUMPAGES }", result.getField().getFieldCode());
        assertEquals("5.0.22.0", result.getField().getNodeId());
    }

    /*
     * Test for posting field.
     */
    @Test
    public void testUpdateField() throws ApiException, MessagingException, IOException
    {
        String localFileName = "GetField.docx";
        String remoteFileName = "TestUpdateField.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, fieldFolder + "/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        FieldUpdate requestField = new FieldUpdate();
        requestField.setFieldCode("{ NUMPAGES }");

        UpdateFieldRequest request = new UpdateFieldRequest(
            remoteFileName,
            0,
            requestField,
            "sections/0/paragraphs/0",
            remoteDataFolder,
            null,
            null,
            null,
            null,
            null,
            null
        );

        FieldResponse result = TestInitializer.wordsApi.updateField(request);
        assertNotNull(result);
        assertNotNull(result.getField());
        assertEquals("{ NUMPAGES }", result.getField().getFieldCode());
        assertEquals("0.0.0.0", result.getField().getNodeId());
    }

    /*
     * Test for posting field online.
     */
    @Test
    public void testUpdateFieldOnline() throws ApiException, MessagingException, IOException
    {
        FieldUpdate requestField = new FieldUpdate();
        requestField.setFieldCode("{ NUMPAGES }");

        UpdateFieldOnlineRequest request = new UpdateFieldOnlineRequest(
            Files.readAllBytes(Paths.get(TestInitializer.LocalTestFolder, fieldFolder + "/GetField.docx").toAbsolutePath()),
            requestField,
            0,
            "sections/0/paragraphs/0",
            null,
            null,
            null,
            null,
            null
        );

        UpdateFieldOnlineResponse result = TestInitializer.wordsApi.updateFieldOnline(request);
        assertNotNull(result);
    }

    /*
     * Test for inserting page numbers field.
     */
    @Test
    public void testInsertPageNumbers() throws ApiException, MessagingException, IOException
    {
        String localFileName = "test_multi_pages.docx";
        String remoteFileName = "TestInsertPageNumbers.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, "Common/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        PageNumber requestPageNumber = new PageNumber();
        requestPageNumber.setAlignment("center");
        requestPageNumber.setFormat("{PAGE} of {NUMPAGES}");

        InsertPageNumbersRequest request = new InsertPageNumbersRequest(
            remoteFileName,
            requestPageNumber,
            remoteDataFolder,
            null,
            null,
            null,
            TestInitializer.RemoteTestOut + "/" + remoteFileName,
            null,
            null
        );

        DocumentResponse result = TestInitializer.wordsApi.insertPageNumbers(request);
        assertNotNull(result);
        assertNotNull(result.getDocument());
        assertEquals("TestInsertPageNumbers.docx", result.getDocument().getFileName());
    }

    /*
     * Test for inserting page numbers field online.
     */
    @Test
    public void testInsertPageNumbersOnline() throws ApiException, MessagingException, IOException
    {
        String localFileName = "test_multi_pages.docx";

        PageNumber requestPageNumber = new PageNumber();
        requestPageNumber.setAlignment("center");
        requestPageNumber.setFormat("{PAGE} of {NUMPAGES}");

        InsertPageNumbersOnlineRequest request = new InsertPageNumbersOnlineRequest(
            Files.readAllBytes(Paths.get(TestInitializer.LocalTestFolder, "Common/" + localFileName).toAbsolutePath()),
            requestPageNumber,
            null,
            null,
            null,
            null,
            null
        );

        InsertPageNumbersOnlineResponse result = TestInitializer.wordsApi.insertPageNumbersOnline(request);
        assertNotNull(result);
    }

    /*
     * Test for deleting field.
     */
    @Test
    public void testDeleteField() throws ApiException, MessagingException, IOException
    {
        String localFileName = "GetField.docx";
        String remoteFileName = "TestDeleteField.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, fieldFolder + "/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        DeleteFieldRequest request = new DeleteFieldRequest(
            remoteFileName,
            0,
            "sections/0/paragraphs/0",
            remoteDataFolder,
            null,
            null,
            null,
            null,
            null,
            null
        );

        TestInitializer.wordsApi.deleteField(request);
    }

    /*
     * Test for deleting field online.
     */
    @Test
    public void testDeleteFieldOnline() throws ApiException, MessagingException, IOException
    {
        DeleteFieldOnlineRequest request = new DeleteFieldOnlineRequest(
            Files.readAllBytes(Paths.get(TestInitializer.LocalTestFolder, fieldFolder + "/GetField.docx").toAbsolutePath()),
            0,
            "sections/0/paragraphs/0",
            null,
            null,
            null,
            null,
            null
        );

        File result = TestInitializer.wordsApi.deleteFieldOnline(request);
        assertNotNull(result);
    }

    /*
     * Test for deleting field without node path.
     */
    @Test
    public void testDeleteFieldWithoutNodePath() throws ApiException, MessagingException, IOException
    {
        String localFileName = "GetField.docx";
        String remoteFileName = "TestDeleteFieldWithoutNodePath.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, fieldFolder + "/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        DeleteFieldRequest request = new DeleteFieldRequest(
            remoteFileName,
            0,
            null,
            remoteDataFolder,
            null,
            null,
            null,
            null,
            null,
            null
        );

        TestInitializer.wordsApi.deleteField(request);
    }

    /*
     * Test for deleting paragraph fields.
     */
    @Test
    public void testDeleteParagraphFields() throws ApiException, MessagingException, IOException
    {
        String localFileName = "test_multi_pages.docx";
        String remoteFileName = "TestDeleteParagraphFields.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, "Common/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        DeleteFieldsRequest request = new DeleteFieldsRequest(
            remoteFileName,
            "paragraphs/0",
            remoteDataFolder,
            null,
            null,
            null,
            null,
            null,
            null
        );

        TestInitializer.wordsApi.deleteFields(request);
    }

    /*
     * Test for deleting paragraph fields without node path.
     */
    @Test
    public void testDeleteParagraphFieldsWithoutNodePath() throws ApiException, MessagingException, IOException
    {
        String localFileName = "test_multi_pages.docx";
        String remoteFileName = "TestDeleteParagraphFieldsWithoutNodePath.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, "Common/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        DeleteFieldsRequest request = new DeleteFieldsRequest(
            remoteFileName,
            null,
            remoteDataFolder,
            null,
            null,
            null,
            null,
            null,
            null
        );

        TestInitializer.wordsApi.deleteFields(request);
    }

    /*
     * Test for deleting section fields.
     */
    @Test
    public void testDeleteSectionFields() throws ApiException, MessagingException, IOException
    {
        String localFileName = "test_multi_pages.docx";
        String remoteFileName = "TestDeleteSectionFields.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, "Common/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        DeleteFieldsRequest request = new DeleteFieldsRequest(
            remoteFileName,
            "sections/0",
            remoteDataFolder,
            null,
            null,
            null,
            null,
            null,
            null
        );

        TestInitializer.wordsApi.deleteFields(request);
    }

    /*
     * Test for deleting section fields without node path.
     */
    @Test
    public void testDeleteSectionFieldsWithoutNodePath() throws ApiException, MessagingException, IOException
    {
        String localFileName = "test_multi_pages.docx";
        String remoteFileName = "TestDeleteSectionFieldsWithoutNodePath.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, "Common/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        DeleteFieldsRequest request = new DeleteFieldsRequest(
            remoteFileName,
            null,
            remoteDataFolder,
            null,
            null,
            null,
            null,
            null,
            null
        );

        TestInitializer.wordsApi.deleteFields(request);
    }

    /*
     * Test for deleting paragraph fields in section.
     */
    @Test
    public void testDeleteSectionParagraphFields() throws ApiException, MessagingException, IOException
    {
        String localFileName = "test_multi_pages.docx";
        String remoteFileName = "TestDeleteSectionParagraphFields.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, "Common/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        DeleteFieldsRequest request = new DeleteFieldsRequest(
            remoteFileName,
            "sections/0/paragraphs/0",
            remoteDataFolder,
            null,
            null,
            null,
            null,
            null,
            null
        );

        TestInitializer.wordsApi.deleteFields(request);
    }

    /*
     * Test for deleting fields.
     */
    @Test
    public void testDeleteDocumentFields() throws ApiException, MessagingException, IOException
    {
        String localFileName = "test_multi_pages.docx";
        String remoteFileName = "TestDeleteSectionParagraphFields.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, "Common/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        DeleteFieldsRequest request = new DeleteFieldsRequest(
            remoteFileName,
            "",
            remoteDataFolder,
            null,
            null,
            null,
            null,
            null,
            null
        );

        TestInitializer.wordsApi.deleteFields(request);
    }

    /*
     * Test for deleting fields online.
     */
    @Test
    public void testDeleteDocumentFieldsOnline() throws ApiException, MessagingException, IOException
    {
        String localFileName = "Common/test_multi_pages.docx";

        DeleteFieldsOnlineRequest request = new DeleteFieldsOnlineRequest(
            Files.readAllBytes(Paths.get(TestInitializer.LocalTestFolder, localFileName).toAbsolutePath()),
            "",
            null,
            null,
            null,
            null,
            null
        );

        File result = TestInitializer.wordsApi.deleteFieldsOnline(request);
        assertNotNull(result);
    }

    /*
     * Test for posting updated fields.
     */
    @Test
    public void testUpdateDocumentFields() throws ApiException, MessagingException, IOException
    {
        String localFileName = "test_multi_pages.docx";
        String remoteFileName = "TestUpdateDocumentFields.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, "Common/" + localFileName),
            remoteDataFolder + "/" + remoteFileName
        );

        UpdateFieldsRequest request = new UpdateFieldsRequest(
            remoteFileName,
            remoteDataFolder,
            null,
            null,
            null,
            null
        );

        DocumentResponse result = TestInitializer.wordsApi.updateFields(request);
        assertNotNull(result);
        assertNotNull(result.getDocument());
        assertEquals("TestUpdateDocumentFields.docx", result.getDocument().getFileName());
    }

    /*
     * Test for posting updated fields online.
     */
    @Test
    public void testUpdateDocumentFieldsOnline() throws ApiException, MessagingException, IOException
    {
        String localFile = "Common/test_multi_pages.docx";

        UpdateFieldsOnlineRequest request = new UpdateFieldsOnlineRequest(
            Files.readAllBytes(Paths.get(TestInitializer.LocalTestFolder, localFile).toAbsolutePath()),
            null,
            null,
            null
        );

        UpdateFieldsOnlineResponse result = TestInitializer.wordsApi.updateFieldsOnline(request);
        assertNotNull(result);
    }
}
