package cn.com.fullstack;

import cn.com.fullstack.study7.Document;
import cn.com.fullstack.study7.ScanFolder;
import cn.com.fullstack.study7.Word;

import java.util.List;

/**
 * Created by JM on 2016-10-16.
 */
public class ScanFolderTest {

    public static void main(String[] args) {
        String path = "D:\\testfolder";
        ScanFolder scanFolder = new ScanFolder(1);
        scanFolder.scan(path,0);
        List<Document> documentList = scanFolder.getDocumentList();
        for(Document doc:documentList){
            System.out.println(doc);
            for(Word word:doc.getWords()){
                System.out.println(word);
            }
        }
    }

}
