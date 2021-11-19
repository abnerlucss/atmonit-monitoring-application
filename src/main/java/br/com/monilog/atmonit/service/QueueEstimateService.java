/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.monilog.atmonit.service;

import com.github.britooo.looca.api.core.Looca;

/**
 *
 * @author jonas
 */
public class QueueEstimateService {

    public void startLoop() {
        Boolean terminalEmUso = false; //Dado mocado
        Looca looca = new Looca();
        Boolean activeSession = false;

        while (true) {
            if (terminalEmUso) {
                if (!activeSession) {
                    insertData(false);
                    //Salvar data e hora no banco
                    activeSession = true;
                }
            } else {
                if (activeSession) {
                    insertData(true);
                    activeSession = false;
                }
            }
        }
    }

    public void insertData(Boolean activeSession) {
        new Thread() {

            @Override
            public void run() {
                

            }
        }.start();
    }
}
