package io.github.matheusfontana.city.teams.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public abstract class BaseService {
    protected ObjectMapper objectMapper = new ObjectMapper();

    protected abstract List<?> readJsonFile() throws IOException;
}
