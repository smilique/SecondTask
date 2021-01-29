package com.epam.training.tasks.second.data;

import java.util.List;

public interface DataReader {

     List<String> readData() throws DataReaderException;
     List<String> readData(String path) throws DataReaderException;

}
