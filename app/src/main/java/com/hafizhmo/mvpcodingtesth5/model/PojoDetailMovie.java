
package com.hafizhmo.mvpcodingtesth5.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PojoDetailMovie {

    @SerializedName("adult")
    public Boolean mAdult;
    @SerializedName("backdrop_path")
    public String mBackdropPath;
    @SerializedName("belongs_to_collection")
    public BelongsToCollection mBelongsToCollection;
    @SerializedName("budget")
    public Long mBudget;
    @SerializedName("credits")
    public Credits mCredits;
    @SerializedName("genres")
    public List<Genre> mGenres;
    @SerializedName("homepage")
    public String mHomepage;
    @SerializedName("id")
    public Long mId;
    @SerializedName("imdb_id")
    public String mImdbId;
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
    @SerializedName("production_companies")
    public List<ProductionCompany> mProductionCompanies;
    @SerializedName("production_countries")
    public List<ProductionCountry> mProductionCountries;
    @SerializedName("release_date")
    public String mReleaseDate;
    @SerializedName("revenue")
    public Long mRevenue;
    @SerializedName("runtime")
    public Long mRuntime;
    @SerializedName("spoken_languages")
    public List<SpokenLanguage> mSpokenLanguages;
    @SerializedName("status")
    public String mStatus;
    @SerializedName("tagline")
    public String mTagline;
    @SerializedName("title")
    public String mTitle;
    @SerializedName("video")
    public Boolean mVideo;
    @SerializedName("vote_average")
    public Double mVoteAverage;
    @SerializedName("vote_count")
    public Long mVoteCount;

    public static class BelongsToCollection {
        @SerializedName("backdrop_path")
        public String mBackdropPath;
        @SerializedName("id")
        public Long mId;
        @SerializedName("name")
        public String mName;
        @SerializedName("poster_path")
        public String mPosterPath;
    }

    public static class Genre {
        @SerializedName("id")
        public Long mId;
        @SerializedName("name")
        public String mName;
    }

    public static class ProductionCompany {
        @SerializedName("id")
        public Long mId;
        @SerializedName("logo_path")
        public String mLogoPath;
        @SerializedName("name")
        public String mName;
        @SerializedName("origin_country")
        public String mOriginCountry;
    }

    public static class ProductionCountry {
        @SerializedName("iso_3166_1")
        public String mIso31661;
        @SerializedName("name")
        public String mName;
    }

    public static class SpokenLanguage {
        @SerializedName("english_name")
        public String mEnglishName;
        @SerializedName("iso_639_1")
        public String mIso6391;
        @SerializedName("name")
        public String mName;
    }

    public static class Credits {
        @SerializedName("cast")
        public List<Cast> mCast;
        @SerializedName("crew")
        public List<Crew> mCrew;

        public static class Cast {
            @SerializedName("adult")
            public Boolean mAdult;
            @SerializedName("cast_id")
            public Long mCastId;
            @SerializedName("character")
            public String mCharacter;
            @SerializedName("credit_id")
            public String mCreditId;
            @SerializedName("gender")
            public Long mGender;
            @SerializedName("id")
            public Long mId;
            @SerializedName("known_for_department")
            public String mKnownForDepartment;
            @SerializedName("name")
            public String mName;
            @SerializedName("order")
            public Long mOrder;
            @SerializedName("original_name")
            public String mOriginalName;
            @SerializedName("popularity")
            public Double mPopularity;
            @SerializedName("profile_path")
            public String mProfilePath;
        }

        public static class Crew {
            @SerializedName("adult")
            public Boolean mAdult;
            @SerializedName("credit_id")
            public String mCreditId;
            @SerializedName("department")
            public String mDepartment;
            @SerializedName("gender")
            public Long mGender;
            @SerializedName("id")
            public Long mId;
            @SerializedName("job")
            public String mJob;
            @SerializedName("known_for_department")
            public String mKnownForDepartment;
            @SerializedName("name")
            public String mName;
            @SerializedName("original_name")
            public String mOriginalName;
            @SerializedName("popularity")
            public Double mPopularity;
            @SerializedName("profile_path")
            public Object mProfilePath;
        }
    }

}
