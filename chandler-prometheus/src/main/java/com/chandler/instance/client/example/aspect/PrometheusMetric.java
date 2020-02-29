/*
 * chandler-prometheus
 * 2020/2/29 10:06 AM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.instance.client.example.aspect;

import io.micrometer.core.instrument.ImmutableTag;
import io.micrometer.core.instrument.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2020/2/29 10:06 AM
 * @version 1.0.0
 * @since 1.8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrometheusMetric {
    private final String PLACEHOLEDER = "_";
    private String name;
    private String prefix = "";
    private String suffix = "";
    private Map<String, String> labels = new LinkedHashMap<>();
    private MetricType type;

    public void addLabel(String k, String v) {
        labels.put(k, v);
    }

    public String getMetricName() {
        if (StringUtils.isNotBlank(prefix)) {
            prefix = prefix.startsWith(PLACEHOLEDER, prefix.length() - 1) ? prefix : prefix + PLACEHOLEDER;
            name = prefix + name;
        }
        if (StringUtils.isNotBlank(suffix)) {
            suffix = suffix.startsWith(PLACEHOLEDER) ? suffix : PLACEHOLEDER + suffix;
            name = name + suffix;
        }
        return name;

    }

    public Iterable<Tag> getTags() {
        List<Tag> tags = new ArrayList<>();
        labels.forEach((k, v) -> {
            Tag tag = new ImmutableTag(k, v);
            tags.add(tag);
        });
        return tags;
    }
}
