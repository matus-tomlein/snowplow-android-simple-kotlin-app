package com.snowplowanalytics.snowplow.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.snowplowanalytics.snowplow.Snowplow
import com.snowplowanalytics.snowplow.configuration.NetworkConfiguration
import com.snowplowanalytics.snowplow.configuration.TrackerConfiguration
import com.snowplowanalytics.snowplow.event.Structured

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val networkConfig = NetworkConfiguration("https://8382-90-64-209-27.ngrok.io")
        val trackerConfig = TrackerConfiguration("appId")
            .installAutotracking(true)

        val tracker = Snowplow.createTracker(applicationContext, "ns", networkConfig, trackerConfig)
        tracker.track(Structured("cat", "act"))
    }
}
