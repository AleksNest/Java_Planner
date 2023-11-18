package model;

import java.util.ArrayList;

public class ReadyQueue {                               // готовая очередь
    private ArrayList<Process> queue;

    public ReadyQueue()
    {
        queue = new ArrayList<>();
    }       // инициализация очереди задач

    public Process dequeue()
    {
        Process p = null;
        if (!isEmpty())
        {
            p = queue.get(0);
            queue.remove(p);
        }
        return p;
    }

//    public Process peek()
//    {
//        if(queue.isEmpty()){
//            return null;
//        }
//        else{
//            return queue.get(0);
//        }
//    }

    public void enqueue(Process process)            // метод
    {
        //случай, когда очередь пуста
        if (queue.isEmpty()) {
            queue.add(process);
        }
        else if(!this.contain(process)){
            int i;
            for ( i = 0; i < queue.size(); i++) {
                if (queue.get(i).getPriority() > process.getPriority()) {
                    queue.add(i,process);
                    break;
                }
            }
            //когда приоритет добавленного процесса выше, чем у всех процессов
            if(i == queue.size() ){
                queue.add(process);
            }
        }
    }

    private boolean contain(Process process){
        for(Process p : queue){
            if(p.getProcessID() == process.getProcessID())
                return true;
            return false;
        }
        return false;
    }

    public int size()
    {
        return queue.size();
    }               // метод возвращает размер списка очередь

    public Boolean isEmpty()
    {
        return (queue.size() == 0);
    }   // возвращает True когда очередь пуста
}
