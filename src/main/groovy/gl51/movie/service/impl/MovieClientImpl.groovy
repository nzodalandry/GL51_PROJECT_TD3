package gl51.movie.service.impl

import gl51.movie.data.Movie
import gl51.movie.service.MovieClient
import gl51.movie.service.MovieRegistry

import javax.inject.Singleton

@Singleton
class MovieClientImpl implements MovieClient {
    Movie getMovieDetail(String imdbID){
        Movie movie = new Movie()
        movie.setImdbID(imdbID);
        movie
    }

}
