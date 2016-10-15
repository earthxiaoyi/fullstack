package cn.com.fullstack.study6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by jiaming.jiang on 2016/10/10.
 */
public class ConcurrentUtils<T> {

    private ExecutorService executorService;

    public ConcurrentUtils(int threadsNum){
        this.init(threadsNum);
    }

    private void init(int threadsNum){
        executorService = Executors.newFixedThreadPool(threadsNum);
    }

    public List<Future<T>> submit(List<Callable> callableList){
        List<Future<T>> futureList = new ArrayList<>();
        for(Callable c:callableList){
            Future future = executorService.submit(c);
            futureList.add(future);
        }
        return futureList;
    }

    public List<T> getResults(List<Future<T>> futureList){
        List<T> resultList = new ArrayList<>();
        for(Future<T> future:futureList){
            T t = null;
            try {
                t = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            resultList.add(t);
        }
        return resultList;
    }

    public void shutDown(){
        executorService.shutdown();
    }
}
