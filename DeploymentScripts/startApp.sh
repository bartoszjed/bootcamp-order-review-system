#!/bin/sh
SERVICE_NAME=OrderReviewApp
PID_PATH_NAME=/tmp/OrderReviewApp-PID

cd ./deploy/
PATH_TO_JAR=`ls -tr | tail -1`

echo "Starting $SERVICE_NAME ..."
        if [ ! -f $PID_PATH_NAME ]; then
            nohup java -jar $PATH_TO_JAR /tmp 2>> /dev/null >> /dev/null &
                        echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started ..."
        else
            echo "$SERVICE_NAME is already running ..."
        fi
