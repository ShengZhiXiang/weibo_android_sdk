/*
 * Copyright (C) 2010-2013 The SINA WEIBO Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.WeiboAppManager.WeiboInfo;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.constant.WBConstants;

/**
 * 该类封装了第三方应用主动向微博发起的分享多条消息的请求。
 * @see {@link IWeiboShareAPI#sendRequest(BaseRequest)}
 * 
 * @author SINA
 * @since 2013-10-29
 */
public class SendMultiMessageToWeiboRequest extends BaseRequest {
    public WeiboMultiMessage multiMessage;

    public SendMultiMessageToWeiboRequest() {
    }

    public SendMultiMessageToWeiboRequest(Bundle data) {
        fromBundle(data);
    }

    @Override
    public int getType() {
        return WBConstants.COMMAND_TO_WEIBO;
    }

    @Override
    public void fromBundle(Bundle data) {
        super.fromBundle(data);
        this.multiMessage = new WeiboMultiMessage(data);
    }

    @Override
    public void toBundle(Bundle data) {
        super.toBundle(data);
        data.putAll(multiMessage.toBundle(data));
    }

    @Override
    final boolean check(Context context, WeiboInfo weiboInfo, VersionCheckHandler handler) {
        if (null == this.multiMessage || weiboInfo == null || !weiboInfo.isLegal()) {
            return false;
        }

        if (handler != null) {
            if (!handler.checkRequest(context, 
                    weiboInfo, 
                    this.multiMessage)) {
                return false;
            }
        }

        return this.multiMessage.checkArgs();
    }
}
