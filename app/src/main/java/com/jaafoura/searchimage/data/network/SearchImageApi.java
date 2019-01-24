package com.jaafoura.searchimage.data.network;

import com.jaafoura.searchimage.data.model.ResponseEntity;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Contain access to remote data
 */
public interface SearchImageApi {

    @GET("/search/photos")
    Single<ResponseEntity> getImages(@Query("client_id") String accessKey, @Query("query") String query);

}
