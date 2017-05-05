package controller;

import controller.gen.TechnologiesOfLocalNetworksService;
import org.apache.thrift.TApplicationException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by G710 on 25.03.2017.
 */
public class Controller {
    private TechnologiesOfLocalNetworksService.Client client;

    public Controller() {
        try {
            TTransport transport;
            transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            client = new TechnologiesOfLocalNetworksService.Client(protocol);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public String create(String name, String definition) {
        String response = null;
        try {
            response = client.createDefinition(name, definition);
        } catch (TException e) {
            e.printStackTrace();
        }
        return response;
    }

    public String read(String name) {
        String response = null;
        try {
            response = client.readDefinition(name);
        } catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public String update(String name, String definition) {
        String response = null;
        try {
            response = client.updateDefinition(name, definition);
        } catch (TException e) {
            e.printStackTrace();
        }
        return response;
    }

    public String delete(String name) {
        String response = null;
        try {
            response = client.deleteDefinition(name);
        } catch (TApplicationException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
        return response;
    }
}
