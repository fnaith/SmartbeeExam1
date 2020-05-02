import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';

import global_data from '../../store/global_data';

import CompanyInfoName from './CompanyInfoName';
import CompanyInfoAddress from './CompanyInfoAddress';

interface Props {
  index: number;
}

function CompanyInfo(props: Props) {
  const { index } = props;

  const onSaveClick = (event: any) => {
    global_data.saveCompanyInfo(index, () => global_data.readCompanies(
      () => global_data.updateControlPanel()
    ));
  };

  const onRemoveClick = (event: any) => {
    global_data.removeCompanyInfo(index, () => global_data.readCompanies(
      () => global_data.updateControlPanel()
    ));
  };

  return (
    <div>
      <CompanyInfoName index={index} />
      <CompanyInfoAddress index={index} />
      <TextField id={'companyForm-created-by-' + index} label="CreatedBy" disabled
        defaultValue={global_data.companyInfos[index].createdBy} margin="dense"/>
      <TextField id={'companyForm-created-at-' + index} label="CreatedAt" disabled
        defaultValue={global_data.formatTime(global_data.companyInfos[index].createdAt)} margin="dense"/>
      <TextField id={'companyForm-updated-by-' + index} label="UpdatedBy" disabled
        defaultValue={global_data.companyInfos[index].updatedBy} margin="dense"/>
      <TextField id={'companyForm-updated-at-' + index} label="UpdatedAt" disabled
        defaultValue={global_data.formatTime(global_data.companyInfos[index].updatedAt)} margin="dense"/>
      <Button variant="contained" color="primary" onClick={onSaveClick}>
        Save
      </Button>
      <Button variant="contained" color="primary" onClick={onRemoveClick}>
        Remove
      </Button>
    </div>
  );
}

export default CompanyInfo;
