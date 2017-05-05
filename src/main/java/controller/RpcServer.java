package controller;

import controller.gen.TechnologiesOfLocalNetworksService;
import model.DbConnection;

/**
 * Created by G710 on 25.03.2017.
 */
public class RpcServer {

    private RpcHandler handler;
    private TechnologiesOfLocalNetworksService.Processor<RpcHandler> processor;
    private ProcessorRunner runner;

    public RpcServer() {
        try{
            DbConnection dbConnection = DbConnection.getInstance();
            dbConnection.connectionDb();

            handler = new RpcHandler();
            processor = new TechnologiesOfLocalNetworksService.Processor<>(handler);
            runner = new ProcessorRunner(processor);

            new Thread(runner).start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
