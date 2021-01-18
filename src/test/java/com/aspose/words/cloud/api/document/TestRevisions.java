/*
 * --------------------------------------------------------------------------------
 * <copyright company="Aspose" file="TestRevisions.java">
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

package com.aspose.words.cloud.api.document;

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
 * Example of how to accept all revisions in document.
 */
public class TestRevisions  extends TestCase
{
    private String remoteDataFolder = TestInitializer.RemoteTestFolder + "/DocumentActions/Revisions";
    private String localFile = "Common/test_multi_pages.docx";


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        TestInitializer.Initialize();
    }

    /*
     * Test for accepting revisions in document.
     */
    @Test
    public void testAcceptAllRevisions() throws ApiException, MessagingException, IOException
    {
        String remoteFileName = "TestAcceptAllRevisions.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, localFile),
            remoteDataFolder + "/" + remoteFileName
        );

        AcceptAllRevisionsRequest request = new AcceptAllRevisionsRequest(
            remoteFileName,
            remoteDataFolder,
            null,
            null,
            null,
            TestInitializer.RemoteTestOut + "/" + remoteFileName
        );

        RevisionsModificationResponse result = TestInitializer.wordsApi.acceptAllRevisions(request);
        assertNotNull(result);
        assertNotNull(result.getResult());
        assertNotNull(result.getResult().getDest());
    }

    /*
     * Test for accepting revisions in document online.
     */
    @Test
    public void testAcceptAllRevisionsOnline() throws ApiException, MessagingException, IOException
    {
        AcceptAllRevisionsOnlineRequest request = new AcceptAllRevisionsOnlineRequest(
            Files.readAllBytes(Paths.get(TestInitializer.LocalTestFolder, localFile).toAbsolutePath()),
            null,
            null,
            null
        );

        AcceptAllRevisionsOnlineResponse result = TestInitializer.wordsApi.acceptAllRevisionsOnline(request);
        assertNotNull(result);
    }

    /*
     * Test for rejecting revisions in document.
     */
    @Test
    public void testRejectAllRevisions() throws ApiException, MessagingException, IOException
    {
        String remoteFileName = "TestRejectAllRevisions.docx";

        TestInitializer.UploadFile(
            PathUtil.get(TestInitializer.LocalTestFolder, localFile),
            remoteDataFolder + "/" + remoteFileName
        );

        RejectAllRevisionsRequest request = new RejectAllRevisionsRequest(
            remoteFileName,
            remoteDataFolder,
            null,
            null,
            null,
            TestInitializer.RemoteTestOut + "/" + remoteFileName
        );

        RevisionsModificationResponse result = TestInitializer.wordsApi.rejectAllRevisions(request);
        assertNotNull(result);
        assertNotNull(result.getResult());
        assertNotNull(result.getResult().getDest());
    }

    /*
     * Test for rejecting revisions in document online.
     */
    @Test
    public void testRejectAllRevisionsOnline() throws ApiException, MessagingException, IOException
    {
        RejectAllRevisionsOnlineRequest request = new RejectAllRevisionsOnlineRequest(
            Files.readAllBytes(Paths.get(TestInitializer.LocalTestFolder, localFile).toAbsolutePath()),
            null,
            null,
            null
        );

        RejectAllRevisionsOnlineResponse result = TestInitializer.wordsApi.rejectAllRevisionsOnline(request);
        assertNotNull(result);
    }
}
