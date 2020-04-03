package gl51.movie.service.impl

import gl51.movie.data.Movie
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MovieRegistryImplTest extends Specification {

    @Inject
    MovieRegistryImpl registry

    void "injection should work"() {
        expect:
            registry != null
    }

    void "favorites should be empty"() {
        expect:
            registry.listFavorites() == []
    }

    void "adding a favorite should fill in the database"() {
        Movie movie = new Movie()
        movie.setImdbID("test");
        when:
            registry.addMovieToFavorites(movie)
        then:
            registry.listFavorites().size() == 1
    }
}
