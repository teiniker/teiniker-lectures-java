package org.se.lab;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DirectoryAnalyzer
{

    public List<Path> getListOfFiles(String directory)
    {
        Path dirPath = Paths.get(directory);
        try (Stream<Path> stream = Files.list(dirPath))
        {
            return stream.toList();
        }
        catch (IOException e)
        {
            throw new ServiceException("Can't read file metadata!", e);
        }
    }

    public List<String> generateFileList(List<Path> fileList)
    {
        try
        {
            List<String> list = new ArrayList<>();
            for (Path path : fileList)
            {
                // Determine whether the path is a directory or a file
                String type = Files.isDirectory(path) ? "Directory" : "File";
                // Get size of file, if it's not a directory
                long size = type.equals("File") ? Files.size(path) : 0;
                // Print the details
                list.add(type + ": " + path.getFileName() + " - Size: " + size + " bytes");
            }
            return list;
        }
        catch (IOException e)
        {
            throw new ServiceException("Can't print file metadata", e);
        }
    }
}