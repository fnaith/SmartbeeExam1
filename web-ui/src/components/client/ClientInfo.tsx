import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';

import global_data from '../../store/global_data';

import ClientInfoCompanyId from './ClientInfoCompanyId';
import ClientInfoName from './ClientInfoName';
import ClientInfoEmail from './ClientInfoEmail';
import ClientInfoPhone from './ClientInfoPhone';

interface Props {
  index: number;
}

function ClientInfo(props: Props) {
  const { index } = props;

  const onSaveClick = (event: any) => {
    global_data.saveClientInfo(index, () => global_data.readCompanies(
      () => global_data.updateControlPanel()
    ));
  };

  const onRemoveClick = (event: any) => {
    global_data.removeClientInfo(index, () => global_data.readCompanies(
      () => global_data.updateControlPanel()
    ));
  };

  return (
    <div>
      <ClientInfoCompanyId index={index} />
      <ClientInfoName index={index} />
      <ClientInfoEmail index={index} />
      <ClientInfoPhone index={index} />
      <TextField id={'clientForm-created-by-' + index} label="CreatedBy" disabled
        defaultValue={global_data.clientInfos[index].createdBy} margin="dense"/>
      <TextField id={'clientForm-created-at-' + index} label="CreatedAt" disabled
        defaultValue={global_data.formatTime(global_data.clientInfos[index].createdAt)} margin="dense"/>
      <TextField id={'clientForm-updated-by-' + index} label="UpdatedBy" disabled
        defaultValue={global_data.clientInfos[index].updatedBy} margin="dense"/>
      <TextField id={'clientForm-updated-at-' + index} label="UpdatedAt" disabled
        defaultValue={global_data.formatTime(global_data.clientInfos[index].updatedAt)} margin="dense"/>
      <Button variant="contained" color="primary" onClick={onSaveClick}>
        Save
      </Button>
      <Button variant="contained" color="primary" onClick={onRemoveClick}>
        Remove
      </Button>
    </div>
  );
}

export default ClientInfo;
