package co.com.lazyloading.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import co.com.lazyloading.domain.LogCarga;

public interface LogCargaRepository extends ElasticsearchRepository<LogCarga, Long>{

}
