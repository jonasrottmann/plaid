package io.plaidapp.data.api.hackernews;


import java.util.List;

import io.plaidapp.data.api.hackernews.model.Item;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;


/**
 * Models the Hacker News API. See https://github.com/HackerNews/API
 */
public interface HackerNewsService {
    String ENDPOINT = "https://hacker-news.firebaseio.com/v0";

    @GET("/topstories.json")
    void getTopstories(Callback<List<Long>> callback);

    @GET("/topstories.json")
    Observable<List<Long>> getTopstories();

    @GET("/item/{itemId}.json")
    void getStory(@Path("itemId") Long itemId, Callback<Item> callback);

    @GET("/item/{itemId}.json")
    Observable<Item> getStory(@Path("itemId") Long itemId);
}
