package v.com.apidemo.Retrofit;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import v.com.apidemo.DataModel.Data;

/**
 * Created by dell on 2/21/2018.
 */

public interface ApiInterface {

    /*@GET("movie/{id}")
 Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);*/

   /* @POST("Attendance/GetEmployeeListForAttendace")
    Call<Model> getEmployeeDetails(@Query("UserID") String UserID, @Query("CityID") String CityID, @Query("SiteID") String SiteID, @Query("ShiftID") String ShiftID, @Query("AttDate") String AttDate);

    @Multipart
    @POST("ProjectPlan/AddUpdateSiteProjectProgress")
    Call<Response> AddProgress(@Query("UserID") String UserID, @Query("site_project_progress_id") String site_project_progress_id,
                               @Query("site_project_id") String site_project_id, @Query("progress_date") String progress_date,
                               @Query("progress_value") String progress_value,
                               @Query("WorkerUsed") String WorkerUsed, @Query("longitute") String longitute, @Query("latitute") String latitute,
                               @Part("file\"; filename=\"pp.png\" ") RequestBody file);


    @Multipart
    @POST("ProjectPlan/AddUpdateSiteProjectProgress")
    Call<Response> AddProgress(@QueryMap Map<String, String> queryMap, @PartMap Map<String, RequestBody> fileMap);
*/

   /* @POST("ProjectPlan/AddUpdateSiteProjectProgress")
    Call<Response> AddProgress(@QueryMap Map<String, String> queryMap);
*/

    @GET("posts")
    Observable<List<Data>> getPosts();

}
