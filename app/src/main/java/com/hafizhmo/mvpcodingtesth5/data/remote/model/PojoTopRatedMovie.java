
package com.hafizhmo.mvpcodingtesth5.data.remote;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PojoTopRatedMovie {

    @SerializedName("page")
    public int mPage;
    @SerializedName("results")
    public List<Result> mResults;
    @SerializedName("total_pages")
    public int mTotalPages;
    @SerializedName("total_results")
    public int mTotalResults;

    public static class Result {
        @SerializedName("adult")
        public Boolean mAdult;
        @SerializedName("backdrop_path")
        public String mBackdropPath;
        @SerializedName("genre_ids")
        public List<Long> mGenreIds;
        @SerializedName("id")
        public int mId;
        @SerializedName("original_language")
        public String mOriginalLanguage;
        @SerializedName("original_title")
        public String mOriginalTitle;
        @SerializedName("overview")
        public String mOverview;
        @SerializedName("popularity")
        public Double mPopularity;
        @SerializedName("poster_path")
        public String mPosterPath;
        @SerializedName("release_date")
        public String mReleaseDate;
        @SerializedName("title")
        public String mTitle;
        @SerializedName("video")
        public Boolean mVideo;
        @SerializedName("vote_average")
        public Double mVoteAverage;
        @SerializedName("vote_count")
        public Long mVoteCount;
    }

//    public Long getPage() {
//        return mPage;
//    }
//
//    public void setPage(Long page) {
//        mPage = page;
//    }
//
//    public List<Result> getResults() {
//        return mResults;
//    }
//
//    public void setResults(List<Result> results) {
//        mResults = results;
//    }
//
//    public Long getTotalPages() {
//        return mTotalPages;
//    }
//
//    public void setTotalPages(Long totalPages) {
//        mTotalPages = totalPages;
//    }
//
//    public Long getTotalResults() {
//        return mTotalResults;
//    }
//
//    public void setTotalResults(Long totalResults) {
//        mTotalResults = totalResults;
//    }

}
