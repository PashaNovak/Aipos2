package controller;

import controller.gen.TechnologiesOfLocalNetworksService;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 * Created by G710 on 25.03.2017.
 */
public class ProcessorRunner implements Runnable{
    private TechnologiesOfLocalNetworksService.Processor proc;

    public ProcessorRunner (TechnologiesOfLocalNetworksService.Processor proc){
        this.proc = proc;
    }

    public void run(){
        try{
            TServerTransport serverTransport = new TServerSocket(9090);
            TThreadPoolServer poolServer =
                    new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(proc));
            System.out.println("Starting server ...");
            poolServer.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
