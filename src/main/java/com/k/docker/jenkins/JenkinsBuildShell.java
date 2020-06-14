package com.k.docker.jenkins;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.k.docker.jenkins.model.DockerJenkinsModel;
import com.k.docker.jenkins.model.emums.DockerParamEnum;
import com.k.docker.jenkins.util.JenkinsUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JenkinsBuildShell {
    private static Map<DockerParamEnum, String> map = Maps.newHashMap();
    static int multi = 1;
    static boolean replace = false;
    static List<String> includes = Lists.newArrayList();
    static List<String> excludes = Lists.newArrayList();

    public static void main(String[] args) throws Exception {
        String arg = args[0];
        String[] splits = StringUtils.split(arg, "@");
        for (String split : splits) {
            if (StringUtils.contains(split, "=")) {
                String[] splitInner = split.split("=");
                DockerParamEnum paramEnum = DockerParamEnum.getEnum(splitInner[0]);
                if (Objects.nonNull(paramEnum)) {
                    map.put(paramEnum, splitInner[1]);
                }
            }
        }
        DockerJenkinsModel.setWORKSPACE(JenkinsUtil.getVal(DockerParamEnum.WORK_SPACE, map));
        {
            multi = Integer.parseInt(JenkinsUtil.getVal(DockerParamEnum.THREAD, map));
        }
        {
            replace = StringUtils.equals("true",JenkinsUtil.getVal(DockerParamEnum.REPLACE, map));
        }
        {
            String val = JenkinsUtil.getVal(DockerParamEnum.INCLUDE, map);
            if (StringUtils.isNotBlank(val)) {
                includes.addAll(Lists.newArrayList(val.split(",")));
            }
        }
        {
            String val = JenkinsUtil.getVal(DockerParamEnum.EXCLUDE, map);
            if (StringUtils.isNotBlank(val)) {
                excludes.addAll(Lists.newArrayList(val.split(",")));
            }
            excludes.add("ubuntu");
        }
        JenkinsUtil shell = new JenkinsUtil();
        shell.jenkinsWrite(multi, includes, excludes, replace);
    }

    @Test
    public void testReplaceTrue() throws Exception {
        JenkinsUtil shell = new JenkinsUtil();
        shell.jenkinsWrite(multi, includes, excludes, true);
    }

    @Test
    public void testReplaceFalse() throws Exception {
        JenkinsUtil shell = new JenkinsUtil();
        shell.jenkinsWrite(multi, includes, excludes, false);
    }
}
