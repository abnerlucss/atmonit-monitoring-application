#!/bin/bash

function baixando_java() {
    echo -e "\033[01;32m[Bot assistente]\033[01;37m: Verificando se temos o java instalado!"

    java -version

    if [ $? -eq 0 ]; then
        echo -e "\033[01;32m[Bot assistente]\033[01;37m: Ok, Você ja tem o Java instalado! vamos para o proximo passo."
    else
        echo -e "\033[01;32m[Bot assistente]\033[01;37m: Sua maquina não tem java você gostaria de instalar java ? (S/N)?"

        read inst

        if [ "$inst" == "s" ]; then
            echo -e "\033[01;32m[Bot assistente]\033[01;37m: Ok! Vamos instalar o Java!"
            sleep 2
            sudo add-apt-repository ppa:webupd8team/java -y
            sleep 2
            sudo apt install default-jre apt install openjdk-11-jre-headless -y
        else
            echo -e "\033[01;32m[Bot assistente]\033[01;37m: Sem java não podemos continuar!"
            exit
        fi
    fi
}

function clone() {
    echo -e "\033[01;32m[Bot assistente]\033[01;37m: Vamos verificar se você tem o git em sua máquina."
    sleep 2
    git --version

    if [ $? -eq 0 ]; then
        echo -e "\033[01;32m[Bot assistente]\033[01;37m: Com o git instalado vamos clonar o repositorio para rodar nossa aplicação."
        git clone -b cli-docker --single-branch https://github.com/abnerlucss/atmonit-monitoring-application.git
        
        executar_app
    else
        echo -e "\033[01;32m[Bot assistente]\033[01;37m: Você não tem o git instalado!"
        echo -e "\033[01;32m[Bot assistente]\033[01;37m: Gostaria de baixar o git (S/N)?"

        read inst

        if [ "$inst" == "s" ]; then
            echo -e "\033[01;32m[Bot assistente]\033[01;37m: Instalando git"
            sleep 2
            sudo apt-get install git-all
            echo -e "\033[01;32m[Bot assistente]\033[01;37m: Clonando repositorio..."
            sleep 2
            git clone -b cli-docker --single-branch https://github.com/abnerlucss/atmonit-monitoring-application.git
      
            executar_app
        else
            echo -e "\033[01;32m[Bot assistente]\033[01;37m: Sem git não podemos continuar!"
            exit
        fi
    fi
}

function executar_app() {
    echo -e "\033[01;32m[Bot assistente]\033[01;37m: Deseja executar a aplicação? (S/N)?"

    read inst

    if [ "$inst" == "s" ]; then
        echo -e "\033[01;32m[Bot assistente]\033[01;37m: Executando a aplicação..."
        sleep 1
        
        cd atmonit-monitoring-application/out/artifacts/atmonit_jar
        java -jar atmonit.jar
    else
        echo -e "\033[01;32m[Bot assistente]\033[01;37m: Caso mude de ideia é só me executar novamente ;D"
        sleep 3
        exit
    fi
}

function ASCII_art() {
    echo -e "\033[01;33m       ___                       ___      \033[01;37m\033[01;32m     ___           ___ \033[01;37m"
    echo -e "\033[01;33m      /  /\          ___        /__/\     \033[01;37m\033[01;32m    /  /\         /__/\        ___           ___ \033[01;37m"
    echo -e "\033[01;33m     /  /::\        /  /\      |  |::\    \033[01;37m\033[01;32m   /  /::\        \  \:\      /  /\         /  /\ \033[01;37m"
    echo -e "\033[01;33m    /  /:/\:\      /  /:/      |  |:|:\   \033[01;37m\033[01;32m  /  /:/\:\        \  \:\    /  /:/        /  /:/ \033[01;37m"
    echo -e "\033[01;33m   /  /:/~/::\    /  /:/     __|__|:|\:\  \033[01;37m\033[01;32m /  /:/  \:\   _____\__\:\  /__/::\       /  /:/ \033[01;37m"
    echo -e "\033[01;33m  /__/:/ /:/\:\  /  /::\    /__/::::| \:\ \033[01;37m\033[01;32m/__/:/ \__\:\ /__/::::::::\ \__\/\:\__   /  /::\ \033[01;37m"
    echo -e "\033[01;33m  \  \:\/:/__\/ /__/:/\:\   \  \:\~~\__\/ \033[01;37m\033[01;32m\  \:\ /  /:/ \  \:\~~\~~\/    \  \:\/\ /__/:/\:\ \033[01;37m"
    echo -e "\033[01;33m   \  \::/      \__\/  \:\   \  \:\       \033[01;37m\033[01;32m \  \:\  /:/   \  \:\  ~~~      \__\::/ \__\/  \:\ \033[01;37m"
    echo -e "\033[01;33m    \  \:\           \  \:\   \  \:\      \033[01;37m\033[01;32m  \  \:\/:/     \  \:\          /__/:/       \  \:\ \033[01;37m"
    echo -e "\033[01;33m     \  \:\           \__\/    \  \:\     \033[01;37m\033[01;32m   \  \::/       \  \:\         \__\/         \__\/ \033[01;37m"
    echo -e "\033[01;33m      \__\/                     \__\/     \033[01;37m\033[01;32m    \__\/         \__\/ \033[01;37m"
    echo ""
    echo ""
}

function main() {
    ASCII_art
    sleep 1
    echo -e "\033[01;32m[Bot assistente]\033[01;37m: Olá, sou o bot assistente e vou te ajudar a instalar o java e git. \n"
    sleep 1
    echo -e "\033[01;32m[Bot assistente]\033[01;37m: Podemos prosseguir (S/N)?"

    read inst

    if [ "$inst" == "s" ]; then
        sleep 1
        baixando_java
        clone
    else
        echo -e "\033[01;32m[Bot assistente]\033[01;37m: Caso mude de ideia é só me executar novamente ;D"
        sleep 3
        exit
    fi
}

main