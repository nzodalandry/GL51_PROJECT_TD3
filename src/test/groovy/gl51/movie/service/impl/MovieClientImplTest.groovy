package gl51.movie.service.impl

import gl51.movie.data.Movie
import gl51.movie.service.MovieClient
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MovieClientImplTest extends Specification {

    @Inject
    MovieRegistryImpl registry
    @Inject
    MovieClientImpl clientMock;

    void "injection should work"() {
        expect:
            registry != null
            clientMock != null
    }

    void "favorites should be empty"() {
        expect:
            registry.listFavorites() == []
    }

    void "check movie by imdbID exist"() {
        Movie movie
        movie = clientMock.getMovieDetail("test")
        when:
            movie != null
        then:
            registry.addMovieToFavorites(movie)
            registry.listFavorites().size() == 1
    }
}