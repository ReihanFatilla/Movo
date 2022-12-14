package com.reift.movieapp.constant

object Constant {

    // Media Type
    const val MEDIA_TV = "tv"
    const val MEDIA_MOVIE = "movie"

    // Movie Discover Sort By
    const val SORT_POPULARITY = "popularity.desc"
    const val SORT_RELEASE = "release_date.desc"
    const val SORT_REVENUE = "revenue.desc"
    const val SORT_RATING = "vote_average.desc"
    const val SORT_VOTE_COUNT = "vote_count.desc"
    const val SORT_TITLE = "original_title.desc"

    // Movie List By
    const val LATEST = "latest"
    const val NOW_PLAYING = "now_playing"
    const val POPULAR_MOVIE = "popular"
    const val TOP_RATED_MOVIE = "top_rated"
    const val UPCOMING = "upcoming"

    // TV Show List By
    const val AIRING_TODAY = "airing_today"
    const val TOP_RATED_TVSHOW = "top_rated"
    const val POPULAR_TVSHOW = "popular"
    const val TOP_RATED = "top_rated"
    const val ON_THE_AIR = "on_the_air"

    // Movie Search By
    const val MOVIE = "movie"
    const val TV_SHOW = "tv"
    const val PEOPLE = "person"
    const val ALL = "multi"

    // Country/Region List
    const val INDONESIA = "ID"
    const val UNITED_STATES = "US"
    const val CHINA = "CN"
    const val ARAB = "AE"
    const val MALASYIA = "MY"

    // Image BaseUrl
    const val IMAGE_BASE_URL = "https://www.themoviedb.org/t/p/w1280"

    // Intent Key
    const val INTENT_TO_DETAIL = "EXTRA_INTENT_DETAIL"
    const val INTENT_TYPE = "EXTRA_INTENT_TYPE"
    const val INTENT_MOVIE = "EXTRA_INTENT_MOVIE"
    const val INTENT_TV = "EXTRA_INTENT_TV"

    // Shared Preference
    const val PREF_BOOKMARK_ID = "PREF_BOOKMARK_ID"
}