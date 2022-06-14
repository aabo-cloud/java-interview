## Shell 脚本


https://javaguide.cn/cs-basics/operating-system/shell-intro.html

将实验参数写入配置文件 `config.properties` 在 `Shell` 脚本中动态写入配置文件。实现实验的批量执行。

运行一次脚本可以执行不同方法的代码。方便实验。



```sh
#! /bin/bash

# 输入节点移动速度和生产者节点数
read -p "input speed and providerNodeCount:" speed providerNodeCount
# 输出日志
echo "[INFO] $speed,$providerNodeCount"

# 删除之前的 results.csv 文件
rm -rf /home/ndnsim/ndnSIM/ns-3/test-results/results.csv
# 输出日志
echo "[INFO] remove results.csv"

# method
methodNameList=(Flooding RRDP LFBL LFBL+RRDP)
methodLFBL=(0 0 1 1)
methodRRDP=(0 1 0 1)

for((k=0; k<${#methodNameList[@]}; k=k+1 ))
do
    echo "[INFO] ${methodNameList[k]} turnOnLFBL=${methodLFBL[k]} turnOnRRDP=${methodRRDP[k]}"
    for((i=1; i<=10; i=i+1 ))
    do
        # 写入配置文件
        echo "consumerSeed=${i}
        consumerNodeCount=1
        providerNodeCount=${providerNodeCount}
        speed=ns3::UniformRandomVariable[Min=${speed}.0|Max=${speed}.0]
        totalNodeCount=64
        simTime=310
        bias=3
        turnOnLFBL=${methodLFBL[k]}
        turnOnRRDP=${methodRRDP[k]}" > /home/ndnsim/ndnSIM/ns-3/test-results/config/config.properties
        # 输出日志
        echo "[INFO] run mobility-$speed-provider-$providerNodeCount-${methodNameList[k]}-$i"
        /home/ndnsim/ndnSIM/ns-3/./waf --run=autotest
    done
done

```

