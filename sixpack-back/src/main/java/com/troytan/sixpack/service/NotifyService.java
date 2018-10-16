package com.troytan.sixpack.service;

import java.util.List;

public interface NotifyService {

    void uploadFormIds(List<String> formIds);

    int notifyUser();
}
