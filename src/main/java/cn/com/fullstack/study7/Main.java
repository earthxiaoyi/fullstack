package cn.com.fullstack.study7;

/**
 * Created by JM on 2016-10-17.
 */
public class Main {

    public static void main(String[] args) {
        String path = "D:\\testfolder";
        String searchKey = "sd";
        SearchInFileI searchInFile = new SearchInFileImpl(path);
        searchInFile.searchInFiles(searchKey);
    }
}
