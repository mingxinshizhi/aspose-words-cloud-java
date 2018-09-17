package com.aspose.words.Common;

import com.aspose.words.Document.TestDocument;
import com.aspose.words.DocumentActions.TestAppendDocument;
import com.aspose.words.DocumentActions.TestClassification;
import com.aspose.words.DocumentActions.TestCompareDocument;
import com.aspose.words.DocumentActions.TestConvertDocument;
import com.aspose.words.DocumentActions.TestDocumentProtection;
import com.aspose.words.DocumentActions.TestDocumentStatistics;
import com.aspose.words.DocumentActions.TestExecuteMailMerge;
import com.aspose.words.DocumentActions.TestExecuteTemplate;
import com.aspose.words.DocumentActions.TestLoadWebDocument;
import com.aspose.words.DocumentActions.TestMailMergeFields;
import com.aspose.words.DocumentActions.TestRevisions;
import com.aspose.words.DocumentActions.TestSplitDocument;
import com.aspose.words.DocumentElements.TestBookmarks;
import com.aspose.words.DocumentElements.TestComments;
import com.aspose.words.DocumentElements.TestDocumentProperties;
import com.aspose.words.DocumentElements.TestDrawingObjects;
import com.aspose.words.DocumentElements.TestFields;
import com.aspose.words.DocumentElements.TestFootnote;
import com.aspose.words.DocumentElements.TestFormFields;
import com.aspose.words.DocumentElements.TestHeaderFooter;
import com.aspose.words.DocumentElements.TestHyperlinks;
import com.aspose.words.DocumentElements.TestMacros;
import com.aspose.words.DocumentElements.TestMathObjects;
import com.aspose.words.DocumentElements.TestPages;
import com.aspose.words.DocumentElements.TestParagraphs;
import com.aspose.words.DocumentElements.TestRuns;
import com.aspose.words.DocumentElements.TestSections;
import com.aspose.words.DocumentElements.TestTables;
import com.aspose.words.DocumentElements.TestText;
import com.aspose.words.DocumentElements.TestWatermarks;
import com.aspose.words.StringUtil;
import com.aspose.words.TestInitializer;
import com.aspose.words.api.WordsApi;
import com.squareup.okhttp.Call;

import junit.framework.TestCase;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class TestApiCoverage extends TestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        TestInitializer.Initialize();
    }

    public void testApiCoverage() {
        Class[] testClasses = new Class[] { TestFont.class, TestDocument.class, TestAppendDocument.class, TestClassification.class,
                TestCompareDocument.class, TestConvertDocument.class, TestDocumentProtection.class, TestDocumentStatistics.class,
                TestExecuteMailMerge.class, TestExecuteTemplate.class, TestLoadWebDocument.class, TestMailMergeFields.class,
                TestRevisions.class, TestSplitDocument.class, TestBookmarks.class, TestComments.class, TestDocumentProperties.class,
                TestDrawingObjects.class, TestFields.class, TestFootnote.class, TestFormFields.class, TestHeaderFooter.class,
                TestHyperlinks.class, TestMacros.class, TestMathObjects.class, TestPages.class, TestParagraphs.class,
                TestRuns.class, TestSections.class, TestTables.class, TestWatermarks.class, TestText.class };
        ArrayList<String> testMethods = new ArrayList<>();
        ArrayList<String> apiMethods = new ArrayList<>();
        ArrayList<String> uncoveredMethods = new ArrayList<>();
        Method[] allApiMethods = WordsApi.class.getDeclaredMethods();
        for (Method m:allApiMethods) {
            if (Modifier.isPublic(m.getModifiers()) && m.getExceptionTypes().length == 1 && m.getReturnType() != Call.class ) {
                apiMethods.add(m.getName());
            }
        }
        for (Class cls: testClasses) {
            Method[] methods = cls.getDeclaredMethods();
            for (Method m: methods) {
                if (Modifier.isPublic(m.getModifiers())){
                    testMethods.add(m.getName());
                }
            }
        }

        for (String m: apiMethods) {
            Boolean found = false;
            for (String tm: testMethods) {
                if (tm.toLowerCase().contains(m.toLowerCase())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                uncoveredMethods.add(m);
            }
        }

        assertEquals("You have to cover these methods with tests " + StringUtil.join("\n", uncoveredMethods.toArray(new String[0])), 0, uncoveredMethods.size());
    }
}
