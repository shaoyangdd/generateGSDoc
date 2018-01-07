package com.ctt.format.setting;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by admin on 2016/12/18.
 */
public class FormatConfigurable implements SearchableConfigurable {

    private FormatForm formatForm;
    private FormatSetting formatSetting = FormatSetting.getInstance();

    public FormatConfigurable() {
    }

    @Override
    @NotNull
    public String getId() {
        return "DocFormat";
    }

    @Override
    @Nls
    public String getDisplayName() {
        return this.getId();
    }

    @Override
    @Nullable
    public String getHelpTopic() {
        return this.getId();
    }

    @Override
    @Nullable
    public JComponent createComponent() {
        if(null == this.formatForm) {
            this.formatForm = new FormatForm();
        }

        return this.formatForm.mainPanel;
    }

    @Override
    public boolean isModified() {
        return !this.formatSetting.getGetFormat().equals(this.formatForm.getFormatTextArea.getText()) || !this.formatSetting.getSetFormat().equals(this.formatForm.setFormatTextArea.getText());
    }

    @Override
    public void apply() throws ConfigurationException {
        this.formatSetting.setGetFormat(this.formatForm.getFormatTextArea.getText());
        this.formatSetting.setSetFormat(this.formatForm.setFormatTextArea.getText());
    }

    @Override
    public void reset() {
        this.formatForm.getFormatTextArea.setText(this.formatSetting.getGetFormat());
        this.formatForm.setFormatTextArea.setText(this.formatSetting.getSetFormat());
    }

}
