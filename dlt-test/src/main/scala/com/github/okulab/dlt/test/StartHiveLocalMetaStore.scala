package com.github.okulab.dlt.test

import org.apache.hadoop.hive.conf.HiveConf
import org.apache.hadoop.hive.metastore.HiveMetaStore
import org.apache.hadoop.hive.thrift.HadoopThriftAuthBridge

/**
  * StartHiveLocalMetaStore
  *
  * @author #okulab-developers<team.dev@okulab.co>
  */
class StartHiveLocalMetaStore extends Runnable {

  var hiveMetastorePort: Int = _
  var hiveConf: HiveConf = _

  def setHiveMetastorePort(hiveMetastorePort: Int) {
    this.hiveMetastorePort = hiveMetastorePort
  }

  def setHiveConf(hiveConf: HiveConf) {
    this.hiveConf = hiveConf
  }

  @Override
  @throws(classOf[Exception])
  def run() {
    try {
      HiveMetaStore.startMetaStore(hiveMetastorePort,
        new HadoopThriftAuthBridge(),
        hiveConf)
    } catch {
      case t: Throwable => t.printStackTrace()
    }
  }
}



