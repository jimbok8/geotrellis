package geotrellis.spark.io.hadoop

import geotrellis.spark._
import geotrellis.spark.io._
import geotrellis.spark.io.index._
import geotrellis.spark.io.hadoop._
import geotrellis.spark.io.hadoop.formats._
import geotrellis.spark.utils._
import geotrellis.raster._

import org.apache.spark.{SparkContext, Logging}
import org.apache.spark.rdd.RDD
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat

import scala.collection.mutable
import org.joda.time.{DateTimeZone, DateTime}

import scala.reflect._

trait RasterRDDReaderProvider[Key] extends Logging {
  def reader(
    catalogConfig: HadoopRasterCatalogConfig,
    layerMetaData: HadoopLayerMetaData,
    keyIndex: KeyIndex[Key],
    keyBounds: KeyBounds[Key]
  )(implicit sc: SparkContext): FilterableRasterRDDReader[Key]
}
