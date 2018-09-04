package com.aspose.words;
import com.aspose.storage.api.StorageApi;
import com.aspose.words.api.WordsApi;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public final class TestInitializer {
    public static StorageApi storageApi;
    public static WordsApi wordApi;

    public static void Initialize() throws FileNotFoundException, ApiException {
        Map<String, String> creds = new Gson().fromJson(new JsonReader(new FileReader("Settings/servercreds.json")), Map.class);
        if (creds == null) {
            throw new FileNotFoundException("Please put your credentials into Settings/servercreds.json file");
        }

        storageApi = new StorageApi(creds.get("BaseUrl"), creds.get("AppKey"), creds.get("AppSid"));
        wordApi = new WordsApi(new ApiClient(creds.get("AppKey"), creds.get("AppSid"), creds.get("BaseUrl")));
    }
}
