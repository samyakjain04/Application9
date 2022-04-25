package com.abc.myapplication9;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface
{
   @GET("/easygautam/data/users")

   Call<List<Movie>> getMovies();

}
