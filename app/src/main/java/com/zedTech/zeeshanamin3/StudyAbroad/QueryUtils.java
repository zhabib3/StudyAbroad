package com.zedTech.zeeshanamin3.StudyAbroad;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public final class QueryUtils {

    private QueryUtils() {

    }

    /**
     * Returns an ArrayList of majors fetched from the backend
     * @param reqUrl
     * @return majorsList
     */
    public static ArrayList<Major> fetchMajors(String reqUrl) {
        // Instantiate a URL obj
        URL url = createUrlObject(reqUrl);
        String jsonRes = null;
        try {
            // Make an http request
            jsonRes = makeHttpReq(url);
        } catch (IOException e) {
            Log.e("QueryUtils", "Error in fetchMajors");
        }

        // Push majors objects in the array list
        ArrayList<Major> majorsList = extractJsonInfo(jsonRes);
        return majorsList;
    }

    /**
     * Returns a URL object with url string passed
     * @param urlString
     * @return url
     */
    private static URL createUrlObject(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            Log.e("QueryUtils", "Malformed URL exception in createUrlObject");
        }
        return url;
    }

    /**
     * Helper method for http connection parsing
     * @param inputStream
     * @return result
     * @throws IOException
     */
    private static String readStream(InputStream inputStream) throws IOException {
        // Use a string builder to avoid high time complexity of string concat
        StringBuilder result = new StringBuilder();

        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();

            // Read from buffer while next line exists
            while (line != null) {
                result.append(line);
                line = bufferedReader.readLine(); // Read next line
            }
        }
        return result.toString();
    }

    /**
     * Make HTTP Request and return the json
     * @param url
     * @return json
     * @throws IOException
     */
    private static String makeHttpReq(URL url) throws IOException {

        String json = "";
        if (url == null) {
            return json;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            // Establish Connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setReadTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Check whether request was successful
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                json = readStream(inputStream);
            } else {
                Log.e("QueryUtils", "HTTP Connection Error Code: " + urlConnection.getResponseCode());
            }

        } catch (IOException e) {
            Log.e("QueryUtils", "IO Exception in makeHttpRequest");
        } finally {

            if (urlConnection != null)
                urlConnection.disconnect();
            if (inputStream != null)
                inputStream.close();
        }
        return  json;

    }


    /**
     * Use json response to populate and return an array list of majors
     * @param json
     * @return majorsList
     */
    private static ArrayList<Major> extractJsonInfo(String json) {
        ArrayList<Major> majorsList = new ArrayList<>();
        if (json == null)
            return null;

        try {
            JSONArray jsonArr = new JSONArray(json);

            // Iterate through the array and create new Majors using JSON info
            for (int i = 0; i < jsonArr.length(); i++) {
                JSONObject majorObj = jsonArr.getJSONObject(i);
                String name = majorObj.getString("name");
                String category = majorObj.getString("category");
                String description = majorObj.getString("desc");

                majorsList.add(new Major(name, category, description));
            }

        } catch (JSONException j) {
            Log.e("QueryUtils", "JSON parsing error");
        }

        return majorsList;
    }


}
