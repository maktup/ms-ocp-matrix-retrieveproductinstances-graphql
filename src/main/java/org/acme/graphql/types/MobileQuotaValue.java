package org.acme.graphql.types;

import java.util.ArrayList;
import java.util.List;

public class MobileQuotaValue {

    private List<VoiceQuota> voiceQuota = new ArrayList<>();
    private List<DataQuota> dataQuota = new ArrayList<>();
    private List<SmsQuota> smsQuota = new ArrayList<>();

    public List<VoiceQuota> getVoiceQuota() {
        return voiceQuota;
    }

    public void setVoiceQuota(List<VoiceQuota> voiceQuota) {
        this.voiceQuota = voiceQuota != null ? voiceQuota : new ArrayList<>();
    }

    public List<DataQuota> getDataQuota() {
        return dataQuota;
    }

    public void setDataQuota(List<DataQuota> dataQuota) {
        this.dataQuota = dataQuota != null ? dataQuota : new ArrayList<>();
    }

    public List<SmsQuota> getSmsQuota() {
        return smsQuota;
    }

    public void setSmsQuota(List<SmsQuota> smsQuota) {
        this.smsQuota = smsQuota != null ? smsQuota : new ArrayList<>();
    }
}
